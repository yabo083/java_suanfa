package com.leetcode;

/**
 * 贴邮票：
 * <br>
 * 用多张大小固定的邮票，贴满矩阵。
 * <br>
 * 0是可以贴的地方，1是不能贴的地方。
 * <br>
 * 涉及三个数组，原始、前缀和、差分
 * <br>
 * build方法先后被用来构建前缀和数组和给差分数组求前缀和
 * <br>
 * sumRegion方法是使用前缀和数组的方法
 * <br>
 * add是构建差分的方法
 * <br>
 * 涉及到差分数组求完前缀和后的原始使用。
 * <br>
 * 目前暂不理解的地方：
 * <br>
 * 1. 前缀和和差分公式的特点怎么记忆？
 * @author Yabo
 * @date 2024/06/24
 */
class lc2132_StampingTheGrid {

    public static void build(int[][] m) {
        // 1. 适用于构建“前缀和”的方法，但总觉得循环次数有问题。
        // 2. ……好吧，我大概知道了，这里之所以不设=，是因为这两重for循环已经能把所有的元素都遍历到了。
        // 3. 想写成之前那样，你得用n和m。
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                m[i][j] += m[i - 1][j] + m[i][j - 1] - m[i - 1][j - 1];
            }
        }
    }

    public static int sumRegion(int[][] sum, int a, int b, int c, int d) {
        // 1. 使用前缀和的方法，公式还记得吧？
        // 2. 而且因为原矩阵就是从1,1开始的，所以也不用偏移。
        return sum[c][d] - sum[a - 1][d] - sum[c][b - 1] + sum[a - 1][b - 1];
    }

    public static void add(int[][] diff, int a, int b, int c, int d) {
        // 1. 构建差分的方法，我想也会。
        diff[a][b] += 1;
        diff[a][d + 1] -= 1;
        diff[c + 1][b] -= 1;
        diff[c + 1][d + 1] += 1;

    }

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        // 1. 获取原始矩阵长与宽
        int n = grid.length;
        int m = grid[0].length;
        // 2. 构建前缀和数组
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, sum[i + 1], 1, m);
        }
        build(sum);
        // 3. 初始化差分数组
        int[][] diff = new int[n + 2][m + 2];
        // 4. for循环，把每个点都作为邮票的可贴左上角点，通过计算获知右下角的坐标
        // 随后利用前缀和判断区域内是否为0，为0才能构建差分，也就是才能贴。
        for (int a = 1, c = a + stampHeight - 1; c <= n; a++, c++) {
            for (int b = 1, d = b + stampWidth - 1; d <= m; b++, d++) {
                if (sumRegion(sum, a, b, c, d) == 0) {
                    add(diff, a, b, c, d);
                }
            }
        }
        // 5. for循环完了，就进行差分数组求前缀和的过程
        build(diff);
        // 6. 双重for循环检查原始矩阵和差分矩阵每个点的状态是否互补？
        // 不互补说明无法贴满，则返回false。
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i - 1][j - 1] == 0 && diff[i][j] == 0) {
                    return false;
                }
            }
        }
        // 7. 通过则返回true。
        return true;

    }


}
