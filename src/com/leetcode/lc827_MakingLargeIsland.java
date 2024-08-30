package com.leetcode;

/**
 * 解法：<br />
 * 因为原先所有的岛都用1标识，<br />
 * 为了区分，我们从2开始，<br />
 * 用递增数值来依次标识我们在双层for循环里遇见的每座岛。<br />
 * <hr>
 * 题目问最大的岛屿面积。<br />
 * 那如果全地图各座岛都无法通过变1相连，可以先统计各个岛的面积。<br />
 * 找出一个最大的。<br />
 * <hr>
 * 设置一个已访问布尔数组，用来去重。<br />
 * 对每个为 0 的矩阵元素的上下左右进行访问，<br />
 * 按照默认顺序进行预合并，<br />
 * 先手工对一个方向进行合并，<br />
 * 随后对剩下三个方向在无重复的前提进行谨慎的合并计数。<br />
 * <hr>
 * 在双层for循环后，理论上已获取最大岛屿面积。<br />
 *
 * @author Yabo
 * @date 2024/08/30
 */
class lc827_MakingLargeIsland {

    public static void dfs(int[][] grid, int n, int m, int i, int j, int id) {
        // 1. 设计边界条件
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || grid[i][j] != 1) {
            return;
        }
        // 2. 实际修改
        grid[i][j] = id;
        // 3. 对四个方向进行递归
        dfs(grid, n, m, i - 1, j, id);
        dfs(grid, n, m, i, j + 1, id);
        dfs(grid, n, m, i + 1, j, id);
        dfs(grid, n, m, i, j - 1, id);
    }

    public int largestIsland(int[][] grid) {
        // 1. 获取矩阵各维度长度
        int n = grid.length;
        int m = grid[0].length;
        // 2. 设置起始标识值，从2开始
        int id = 2;
        // 3. 双层for循环，给每个独立的岛屿用不同的数字标识
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, n, m, i, j, id++);
                }
            }
        }
        // 4. 先行统计每个岛屿面积，顺便获取在未合并前的最大值。
        int[] sizes = new int[id];
        int ans = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] > 1) {
                    ans = Math.max(ans, ++sizes[ints[j]]);
                }
            }
        }
        // 5. 双层for循环，对所有的0讨论，讨论上下左右的可能。
        // 这种写法看着好，实则慢。不如左神的。
//        boolean[] visited = new boolean[id];
//        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (g[i][j] == 0) {
//                    Arrays.fill(visited, false);
//                    int merge = 1;
//
//                    for (int k = 0, ni, nj; k < 4; k++) {
//                        ni = i + dx[k];
//                        nj = j + dy[k];
//
//                        if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[g[ni][nj]]) {
//                            merge += sizes[g[ni][nj]];
//                            visited[g[ni][nj]] = true;
//                        }
//                    }
//                    ans = Math.max(ans, merge);
//                }
//            }
//        }、

        boolean[] visited = new boolean[id];
        int up, down, left, right, merge;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    up = i > 0 ? grid[i - 1][j] : 0;
                    down = i + 1 < n ? grid[i + 1][j] : 0;
                    left = j > 0 ? grid[i][j - 1] : 0;
                    right = j + 1 < m ? grid[i][j + 1] : 0;
                    visited[up] = true;
                    merge = 1 + sizes[up];
                    if (!visited[down]) {
                        merge += sizes[down];
                        visited[down] = true;
                    }
                    if (!visited[left]) {
                        merge += sizes[left];
                        visited[left] = true;
                    }
                    if (!visited[right]) {
                        merge += sizes[right];
                        visited[right] = true;
                    }
                    ans = Math.max(ans, merge);
                    visited[up] = false;
                    visited[down] = false;
                    visited[left] = false;
                    visited[right] = false;
                }
            }
        }

        // 6. 返回答案。
        return ans;
    }
}
