package com.leetcode;

/**
 * 解法：先把处在边界位置的‘O’用dfs感染。<br />
 * 用别种符号标识，与那些内陆湖区别开。<br />
 * 随后，对内陆湖遍历，此次便执行题目要求的操作。<br />
 *
 * @author Yabo
 * @date 2024/08/30
 */
class lc130_SurroundedRegions {

    public static void dfs(char[][] board, int n, int m, int i, int j) {
        // 1. 设计边界条件
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || board[i][j] != 'O') {
            return;
        }
        // 2. 执行实际修改
        board[i][j] = 'F';
        // 3. 对四个方向进行递归调用
        dfs(board, n, m, i - 1, j);
        dfs(board, n, m, i, j + 1);
        dfs(board, n, m, i + 1, j);
        dfs(board, n, m, i, j - 1);
    }

    public void solve(char[][] board) {
        // 1. 获取矩阵各维度长度
        int n = board.length;
        int m = board[0].length;
        // 2. 用两个for循环对处于四边界位置的‘O’进行dfs感染
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, n, m, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, n, m, i, m - 1);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                dfs(board, n, m, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                dfs(board, n, m, n - 1, i);
            }
        }
        // 3. 用双层for循环对每个矩阵元素进行双重检查。
        //     执行题目要求，并顺手清除标记。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
                //     以上都用不着dfs。
            }
        }

    }
}
