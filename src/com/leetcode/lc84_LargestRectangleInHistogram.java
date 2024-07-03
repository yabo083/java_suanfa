package com.leetcode;

/**
 * 题意理解：<br />
 * <hr>
 * 以独立的视角看待每一个柱子，<br />
 * 以其高度向左右两边扩展出一个矩形的条件是：<br />
 * 朋友，你必须得比我高我才能借到方块啊！<br />
 * 换句话说，我必须在比我低的柱子前停止，<br />
 * 于是，我找到了左右极小值的下标，然后通过瞪眼法获得了矩形的宽的计算公式，<br />
 * over！<br />
 * <hr>
 * 相等进不进for由你，无非是把多余处理放在什么时机去算而已。<br />
 * 但是，为了同一这类题的写法，建议一律连同=一起写上！<br />
 * 感觉单调栈的写法自纠错的能力很强<br />
 *
 * @author Yabo
 * @date 2024/07/02
 */
class lc84_LargestRectangleInHistogram {

    public static int MAXN = 100001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public int largestRectangleArea(int[] heights) {
        // 1. 获取高度数组的长度
        int n = heights.length;
        // 2. 初始化栈顶指针
        r = 0;
        // 3. 创建答案变量，公用的top和l
        int ans = 0, top, l;
        // 4. for循环，升序单调栈
        for (int i = 0; i < n; i++) {
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
            ans = Math.max(ans, (n - l - 1) * heights[top]);
        }
        // 6. 返回答案
        return ans;
    }
}
