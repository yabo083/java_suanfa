package com.leetcode;

/**
 * 涉及子数组，往往用前缀和快速计算。<br /> 然后是单调队列的应用，这次居然是构建升序！<br /> 虽然懂头弹的规则，但不是很懂尾进是为什么？<br /> 虽然也有一个粗浅的解释，但总体看起来有点太刻意！<br />
 *
 * @author Yabo
 * @date 2024/08/28
 */
class lc862_ShortestSubarrayWithSumAtLeastK {

    public static int MAXN = 100001;

    // sum[0] : 前0个数的前缀和
    // sum[i] : 前i个数的前缀和
    public static long[] sum = new long[MAXN];

    public static int[] deque = new int[MAXN];

    public static int h, t;

    public int shortestSubarray(int[] nums, int k) {
        // 1. 获取数组长度
        int n = nums.length;
        // 2. 预处理出前缀和数组，范围是从[0,n)
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // 3. 单调队列结构参数初始化
        h = t = 0;
        // 4. 初始化答案变量
        int ans = Integer.MAX_VALUE;
        // 5. for循环，结束后ans就是最短的子数组，且满足条件。
        for (int i = 0; i <= n; i++) {
            //     1. 循环范围[0,n]
            //     2. while循环，当队列不空，且满足条件，则计算长度一次
            while (h != t && sum[i] - sum[deque[h]] >= k) {
                // TODO: 为何此处的长度计算不用+1？答：因为利用前缀和数组计算的原数组本来就不包括左端。
                ans = Math.min(ans, i - deque[h++]);
            }
            //     3. while循环，单调队列更新期。
            //     众所周知，值越小，数组越长。
            //     为了维持这个性质，获得更多的小前缀和，我们可以使大的弹出，换上小的。
            while (h != t && sum[deque[t - 1]] >= sum[i]) {
                t--;
            }
            deque[t++] = i;
        }
        // 6. 返回答案，若不存在，则返回-1。
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
