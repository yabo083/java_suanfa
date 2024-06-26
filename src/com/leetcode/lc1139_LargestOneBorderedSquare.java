package com.leetcode;

/**
 * 主要是利用二维前缀和，来计算每次遍历到的正方形周长是否等于理论值。
 * 如果是，那就更新；否就继续遍历下一个正方形。
 * <br>
 * 理论上，时空复杂度已最优。
 * <br>
 * 为了达到O(1)的空间复杂度，我们复用了原矩阵，将其转换为前缀和数组。
 * <br>
 * 而这样的代价就是，我们需要处理0行和0列的情况。也就是在最初时会有-1减到负数的情况
 * <br>
 * 这样坐标当然不存在，所以直接返回0就好啦。
 * <br>
 * 没问题。嗯，没问题。
 * @author Yabo
 * @date 2024/06/24
 */
class lc1139_LargestOneBorderedSquare {

    public static void build(int n, int m, int[][] g) {
        // 1. 用来原地将原矩阵转换为二维前缀和数组的
        // 2. 公式算法还是一样，只不过关键是在使用的辅助函数
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                g[i][j] += get(g, i - 1, j) + get(g, i, j - 1) - get(g, i - 1, j - 1);
    }

    public static int sum(int[][] g, int a, int b, int c, int d) {
        // 1. 不合理值，返回0；否则返回由（a，b）和（c，d）圈出的正方形的前缀和。
        return a > c ? 0 : get(g, c, d) - get(g, a - 1, d) - get(g, c, b - 1) + get(g, a - 1, b - 1);
    }

    public static int get(int[][] g, int i, int j) {
        // 1. 没超范围，直接返回
        return i < 0 || j < 0 ? 0 : g[i][j];
    }

    public int largest1BorderedSquare(int[][] grid) {
        // 1. 获取矩阵行数
        int n = grid.length;
        // 2. 获取矩阵列数
        int m = grid[0].length;
        // 3. 利用子函数，在原地构建二维前缀和数组
        build(n, m, grid);
        // 4. 特判：如果整个矩阵都是0元素，直接返回0就好
        if (sum(grid, 0, 0, n - 1, m -1) == 0 )
            return 0;
        // 5. 初始化边长变量（值得一提的是，这里的边长并非抽象的数学，而是由实际的
        // 元素构成，所以对其的处理稍有不同）
        int ans = 1;
        // 6. 三重for循环，目的在于遍历从第一行第一列开始，遍历每一个可能的正方形。
        // 为此需要确定两个坐标，（a，b）和（c，d），a与b的值好说，关键是c和d，
        // 他们的初始值是在a和b加上边长合成的，随后，随后为了讨论不同的边长，需再次引入
        // 一个代表边长的临时变量，它与c、d一起递增
        for (int a = 0; a < n; a++)
            for (int b = 0; b < m; b++)
                for (int c = a + ans, d = b + ans, k = ans + 1; c < n && d < m; c ++, d ++, k ++)
                    if (sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d -1) == (k - 1) << 2)
                        ans = k;
        // 7. 关键的判断，希望你独立写出，同时也要明白，这样的更新是一定可以将ans更新
        // 到更大值的。
        // 8. 最后的最后，返回边长的平方，即为最大正方形内，元素的数量。
        return ans * ans;
    }
}
