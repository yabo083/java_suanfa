package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：<br />
 * 遥想上一题，其实差不多，<br />
 * 都是算最大矩形面积，<br />
 * 只是一个是拿一维数组呈现，一个是拿二维数组呈现<br />
 * 那么，降维打击压缩一下，不就可以复用了吗？<br />
 * <hr>
 * 只需注意一点，不能一开始就把所有的数列加到一块，<br />
 * 因为二维矩阵中可能有些地方是0，阻碍更大矩形的形成，<br />
 * 所以要一行一行的累加。<br />
 *
 * @author Yabo
 * @date 2024/07/02
 */
class lc85_MaximalRectangle {

    public static int MAXN = 201;

    public static int[] heights = new int[MAXN];

    public static int[] stack = new int[MAXN];

    public static int r;

    public int maximalRectangle(char[][] matrix) {
        // 1. 获取二维矩阵行数，决定了要算几次最大矩形
        int n = matrix.length;
        // 2. 获取二维矩阵列数，决定了一维化数组的长度
        int m = matrix[0].length;
        // 3. 初始化一维数组的值为0
        Arrays.fill(heights, 0, m, 0);
        // 4. 创建答案变量
        int ans = 0;
        // 5. for循环，流程简述：
        for (int i = 0; i < n; i++) {
        //     1. 计算新的一维数组，是'0'请截断从0重新开始，不是就累加
            for (int j = 0; j < m; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
        //     2. 调用，取max
            ans = Math.max(ans, largestRectangleArea(m));
        }
        // 6. 返回答案
        return ans;
    }

    public int largestRectangleArea(int m) {
        // 1. 获取高度数组的长度,啊……就是m
        // 2. 初始化栈顶指针
        r = 0;
        // 3. 创建答案变量，公用的top和l
        int ans = 0, top, l;
        // 4. for循环，升序单调栈
        for (int i = 0; i < m; i++) {
            while (r > 0 && heights[i] < heights[stack[r - 1]]) {
                top = stack[--r];
                l = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, (i - l - 1) * heights[top]);
            }
            stack[r ++] = i;
        }
        // 5. while循环，处理栈中残余
        while (r > 0){
            top = stack[--r];
            l = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, (m - l - 1) * heights[top]);
        }
        // 6. 返回答案
        return ans;
    }
}
