package com.leetcode;

import java.util.Arrays;

/**
 * 目的：找一个点，这个点重叠的正方形最多
 * <br>
 * 先得离散化，才能差分
 * <br>
 * 但离散化之前的过程有些没看懂，不懂为什么要倍2？
 * <br>
 * 我先试试不倍！
 * <br>
 * 不倍确实可以，但有个新问题：怎么理解（a,b）和（c,d）好像一个是左下角，一个是右上角？
 * <br>
 * ——你得这么理解：a，b，c，d的取值范围基本只能是正整数，而a，b是减半径减出来的，
 * <br>
 * 更靠近差分矩阵的（0,0），旋转一下，不就是左上角？（c，d）同理。
 *
 * @author Yabo
 * @date 2024/06/25
 */
class lcp74_StrongestForceField {

    public static int sort(double[] nums) {
        // 1. 排序
        Arrays.sort(nums);
        // 2. 去重
        int size = 1;
        for (int i = 1  ; i < nums.length; i++) {
            if (nums[i] != nums[size - 1]) {
                nums[size++] = nums[i];
            }
        }
        return size;
        // 3. 返回有效长度
    }

    public static int rank(double[] num, double v, int size) {
        // 1. 用二分法、返回映射后的序号
        int l = 0, r = size -1;
        int m, ans = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (num[m] >= v) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans + 1;
    }

    public static void add(int[][] diff, int a, int b, int c, int d) {
        // 1. 就是二维差分
        diff[a][b] += 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][b] -= 1;
        diff[c + 1][d + 1] += 1;

    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        // 1. 获取有几个力场
        int n = forceField.length;
        // 2. 预创建坐标数组
        double[] xs = new double[n << 1];
        double[] ys = new double[n << 1];
        // 3. for循环处理
        for (int i = 0, k = 0, p = 0; i < n; i++) {
            double x = forceField[i][0];
            double y = forceField[i][1];
            double r = forceField[i][2];
            xs[k++] = x - r/2;
            xs[k++] = x + r/2;
            ys[p++] = y - r/2;
            ys[p++] = y + r/2;
        }
        // 4. 排序、去重、返回有效长度
        int sizeX = sort(xs);
        int sizeY = sort(ys);
        // 5. 创建差分数组
        int[][] diff = new int[sizeX + 2][sizeY + 2];
        // 6. 开始离散化-映射
        for (int[] ints : forceField) {
            double x = ints[0];
            double y = ints[1];
            double r = ints[2];
            int a = rank(xs, x - r/2, sizeX);
            int b = rank(ys, y - r/2, sizeY);
            int c = rank(xs, x + r/2, sizeX);
            int d = rank(ys, y + r/2, sizeY);
            add(diff, a, b, c, d);
        }
        // 7. 求前缀和，同时求出最大值
        int ans = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[0].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);
            }
        }
        // 8. 返回最大值
        return ans;
    }
}
