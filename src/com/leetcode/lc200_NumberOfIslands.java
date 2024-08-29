package com.leetcode;

/**
 * 核心是矩阵展平，也就是二维化一维。<br />
 * 判断的时候还是看左上，但合并的时候就调用函数得到唯一一维位置。<br />
 *
 * @author Yabo
 * @date 2024/08/29
 */
class lc200_NumberOfIslands {

    public static int MAXSIZE = 100001;
    public static int[] father = new int[MAXSIZE];
    public static int cols;
    // 岛屿数
    public static int sets;

    public static void build(int n, int m, char[][] board) {
        cols = m;
        sets = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0, index; b < m; b++) {
                // 只对岛屿建立集合
                if (board[a][b] == '1') {
                    index = index(a, b);
                    father[index] = index;
                    sets++;
                }
            }
        }
    }

    // 辅助函数
    public static int index(int a, int b) {
        return a * cols + b;
    }

    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static void union(int a, int b, int c, int d) {
        // 此处略有不同，得稍微转化一下
        int fx = find(index(a, b));
        int fy = find(index(c, d));
        if (fx != fy) {
            father[fx] = fy;
            sets--;
        }
    }

    public int numIslands(char[][] grid) {
        // 1. 获取行数
        int n = grid.length;
        // 2. 获取列数
        int m = grid[0].length;
        // 3. 构建并查集
        build(n, m, grid);
        // 4. 双重for循环遍历整个二维矩阵，遇到1才查看左和上方，决定是否合并。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i >= 1 && grid[i - 1][j] == '1') {
                        union(i, j, i - 1, j);
                    }
                    if (j >= 1 && grid[i][j - 1] == '1') {
                        union(i, j, i, j - 1);
                    }
                }
            }
        }
        // 5. 返回答案。
        return sets;
    }
}
