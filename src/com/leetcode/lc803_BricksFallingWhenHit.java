package com.leetcode;

class lc803_BricksFallingWhenHit {


    public static int n, m;

    public static int[][] g;

    public static int dfs(int i, int j) {
        // 1. 设计边界条件
        if (i < 0 || i == n || j < 0 || j == m || g[i][j] != 1) {
            return 0;
        }
        // 2. 进行实际修改
        g[i][j] = 2;
        // 3. 对四个方向进行修改，返回统计有多少格被改。
        return 1 + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i + 1, j) + dfs(i, j - 1);
    }

    public static boolean worth(int i, int j) {
        // 1. 判断有无可能砖块掉落的一个子函数
        // 2. 标准是首先你得炮击格恢复后是1，而且如果是天花板的格我们自然要统计；或者周围有2的也得统计。
        return g[i][j] == 1 &&
            (i == 0
                || (i > 0 && g[i - 1][j] == 2)
                || (j < m - 1 && g[i][j + 1] == 2)
                || (i < n - 1 && g[i + 1][j] == 2)
                || (j > 0 && g[i][j - 1] == 2));
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        // 1. 参数全局变量化
        g = grid;
        n = g.length;
        m = g[0].length;
        // 2. 设置答案数组
        int[] ans = new int[hits.length];
        // 3. 对特殊情况进行特判。
        // 如果只有天花板的一排砖块，则怎么炮击都不会掉。
        // 直接返回空数组即可
        if (n == 1) {
            return ans;
        }
        // 4. 进行炮击操作
        for (int[] hit : hits) {
            g[hit[0]][hit[1]]--;
        }
        // 5. 对天花板的一排砖块进行dfs染色
        for (int i = 0; i < m; i++) {
            dfs(0, i);
        }
        // 6. 时间回溯。
        // 倒序恢复炮击格，利用子函数查看是否有砖块掉落，记录至答案数组。
        for (int i = hits.length - 1, col, row; i >= 0; i--) {
            row = hits[i][0];
            col = hits[i][1];
            g[row][col]++;
            if (worth(row, col)) {
                ans[i] = dfs(row, col) - 1;
            }
        }
        // 7. 返回答案。
        return ans;
    }
}
