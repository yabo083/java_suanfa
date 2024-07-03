package com.leetcode;

/**
 * 题意理解：<br>
 * 找右极大值（使用降序单调栈）
 *
 * @author Yabo
 * @date 2024/07/02
 */
class lc739_DailyTemperatures {

    public static int MAXN = 100001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public int[] dailyTemperatures(int[] temperatures) {
        // 1. 获取气温数组长度
        int n = temperatures.length;
        // 2. 创建答案数组
        int[] ans = new int[n];
        // 3. 初始化栈顶指针
        r = 0;
        // 4. for循环，单调栈流程，甚至不用处理循环结束后栈中残留的值
        //     因为根据题意，下一天的气温只有严格大于当日气温才需记录，
        //     而那些等于或小于的天数不需要而填充的值，正好是初始化的默认值0
        for (int i = 0, top; i < n; i++) {
            while (r > 0 && temperatures[i] > temperatures[stack[r - 1]]) {
                top = stack[--r];
                ans[top] = i - top;
            }
            stack[r++] = i;
        }
        // 5. 返回答案
        return ans;
    }
}
