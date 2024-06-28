package com.leetcode;

/**
 * 题意理解：
 * <br>
 * 要求：
 * <br>
 * 1. 找到最小速度——一个点
 * <br>
 * 2. 扩展——速度的区间,大概是[1,香蕉数量最多的那堆]
 * <br>
 * （不论左右，都要好好考虑！因题目设定，导致一定有香蕉，一定得有单位1的时间，也就导致一定得有单位1的速度！）
 * <br>
 * 3. 单调性：（速度越大，时间越少）
 * <br>
 * 4. 判断的意义：如果速度为v，能否在h小时前吃完？——>
 * <br>
 * f函数的意义：如果速度为v，吃完的时间需要多少？
 * <br>
 * 能就尝试降低速度（更悠闲从容）；不能只得提高速度了
 * <hr>
 * 难点：f函数
 * <br>
 * 如何计算以v的速度吃完所有香蕉所需要的时间？
 * <br>
 * 额……每堆香蕉除以速度，再向上取整，然后再累加，
 * <br>
 * 啊，出乎意料地简单！
 *
 * @author Yabo
 * @date 2024/06/28
 */
class lc875_KokoEatingBananas {

    public static long f(int[] piles, int speed) {
        // 1. 初始化答案变量
        long sum = 0;
        // 2. 根据算法计算
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        // 3. 返回答案
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // 1. 确定区间(warning!!区间从1开始，因为这是题目设定)
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        // 2. 初始化二分变量
        int ans = 0, mid = 0;
        // 3. 开始二分
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (f(piles, mid) <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 4. 返回答案
        return ans;
    }
}
