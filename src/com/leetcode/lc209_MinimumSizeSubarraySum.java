package com.leetcode;

/**
 * 简单的滑动窗口，但如果让我自己想一般是出不来的。
 * <br>
 * 但我能很快看懂题解，就证明我应该是会一点的。
 * <br>
 * 所以，把过程重复千百次，就一定可以掌握吧？！
 *
 * @author Yabo
 * @date 2024/06/25
 */
class lc209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        // 1. 创建答案寄存器
        int ans = Integer.MAX_VALUE;
        // 2. 主要的for循环，以r为准，
        // 每次的流程是：
        // 临时和先将r处数计入，随后开始按照条件循环剔除l处的数，
        // 不仅l要左移，临时和也要先减。
        for (int l = 0, r = 0, sum = 0; r < nums.length; r ++) {
            sum += nums[r];
            while (sum - nums[l] >= target) {
                sum -= nums[l ++];
            }
            // 3. 退出while，意味着已经临界，此时便可以寻找新的ans,
            // 但也只有在临时和大于等于目标值时才有更新ans，这样姑且可以跳过一些没必要的情况。
            // 我现在起码能想出2种。不知道有没有更重要的意义？
            if (sum >= target) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        // 4. 最后可以返回了，注意如果ans依旧是原始值，则代表原数组没有满足条件的
        // 直接返回0就好了；而如果有变化，则返回ans本身。
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
