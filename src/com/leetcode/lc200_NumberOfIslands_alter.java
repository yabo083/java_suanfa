package com.leetcode;

/**
 * 还是昨天那道，换了种新做法。<br />
 * “洪水填充”，在我看来，就是在对矩阵元素的四个方向调用dfs罢了。<br />
 * 过程和染色类似。其中数字的标识的意义要确定好。<br />
 * <hr>
 * 核心解法就是，每能进行一次成功的岛屿消灭，就意味着找到一座岛。<br />
 *
 * @author Yabo
 * @date 2024/08/30
 */
class lc200_NumberOfIslands_alter {

    public static void dfs(char[][] board, int n, int m, int i, int j) {
        // 1. 设计退出的边界条件
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || board[i][j] != '1') {
            return;
        }
        // 2. 做实际的修改
        board[i][j] = 0;
        // 3. 向四个方向递归调用
        dfs(board, n, m, i - 1, j);
        dfs(board, n, m, i, j + 1);
        dfs(board, n, m, i + 1, j);
        dfs(board, n, m, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        // 1. 获取矩阵各维长度
        int n = grid.length;
        int m = grid[0].length;
        // 2. 设置岛屿计数变量
        int ans = 0;
        // 3. 双层for循环，结束后计数变量可获得答案。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //     1. 如果是岛屿，就开始深度优先搜索
                if (grid[i][j] == '1') {
                    dfs(grid, n, m, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
