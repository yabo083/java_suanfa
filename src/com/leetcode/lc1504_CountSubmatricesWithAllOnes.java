package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：<br />
 * 据说和找二维数组中全是1的子矩形面积最大的那道题差不多，<br />
 * 但基于每行的计算方法似乎没掌握，<br />
 * <hr>
 * 好吧，注释很详细，基本看懂了<br />
 * 关键点：<br />
 * 1. 求所有子矩形的公式：<br />
 * (cur位置的高度-Max{left位置的高度,i位置的高度}) * ((i-left-1)*(i-left)/2)<br />
 * 2. why? Max{left位置的高度,i位置的高度}?<br />
 * 也就是说，<=4的高度一律不求，>6的高度一律不求！<br />
 * 其他位置也会从栈里弹出，等其他位置弹出的时候去求！<br />
 *
 * @author Yabo
 * @date 2024/07/03
 */
class lc1504_CountSubmatricesWithAllOnes {

    public static int max = 151;

    public static int[] height = new int[max];

    public static int[] stack = new int[max];

    public static int r;

    public static int countFromBottom(int m) {
        // 1. 初始化栈顶指针
        r = 0;
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环，升序单调栈，入的是值渐大的下标
        for (int i = 0; i < m; i++) {
            //     1. 当遇到“严格小于”栈顶的值时，就意味着可以算一次可以产生多少子矩阵。
            //     答案记得是“累加”。
            while (r > 0 && height[stack[r - 1]] > height[i]) {
                int cur = stack[--r];
                int l = r == 0 ? -1 : stack[r - 1];
                int len = i - l - 1;
                ans += (height[cur] - Math.max(l == -1 ? 0 : height[l], height[i])) * len * (len + 1) / 2;
            }
            //     2. 记得入栈。
            stack[r++] = i;
        }
        // 4. while循环处理残余，由于只需考虑一边，公式上简单了一些。
        while (r > 0) {
            int cur = stack[--r];
            int l = r == 0 ? -1 : stack[r - 1];
            int len = m - l - 1;
            ans += (height[cur] - (l == -1 ? 0 : height[l])) * len * (len + 1) / 2;
        }
        // 5. 返回答案
        return ans;
    }

    public int numSubmat(int[][] mat) {
        // 1. 获取矩阵行数
        int n = mat.length;
        // 2. 获取矩阵列数
        int m = mat[0].length;
        // 3. 创建答案变量
        int ans = 0;
        // 4. 初始化一维化压缩数组
        Arrays.fill(height, 0);
        // 5. for循环，转换、压缩，调用子函数累加答案
        for (int[] ints : mat) {
            for (int j = 0; j < m; j++) {
                height[j] = ints[j] == 0 ? 0 : height[j] + 1;
            }
            ans += countFromBottom(m);
        }
        // 6. 返回答案
        return ans;
    }
}
