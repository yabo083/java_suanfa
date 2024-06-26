package com.leetcode;

/**
 * 差分，据说是前缀和的逆运算，但我不是很明白到底逆在哪里了？
 *
 * 差分序列——（前缀和操作）——>原序列
 * 原序列——（逆前缀和操作=差分操作）——>差分序列
 *
 * 呵呵……一句话：差分可以简单的看成序列中每个元素与其前一个元素的差。
 *
 * @author Yabo
 * @date 2024/06/18
 */
class lc1109_CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 1. 准备一个数组，我愿称之为基准数组，它只有一个要求：够长
        int[] cnt = new int[n + 2];
        // 2. 开始for循环，具体是在特定位置加或减
        for (int[] booking : bookings) {
            cnt[booking[0]] += booking[2];
            cnt[booking[1]+1] -= booking[2];
        }
        // 3. 前缀和，范围是从0到最后，可以试试同时把答案转录
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++){
            cnt[i+2] += cnt[i+1];
            ans[i] = cnt[i+1];
        }
        // 4. 返回
        return ans;
    }
}
