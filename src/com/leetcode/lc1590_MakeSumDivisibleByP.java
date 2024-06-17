package com.leetcode;

import java.util.HashMap;

/**
 * 使数组和能被P整除
 *
 * 除不了会余，需要移除最短——和长度有关，map需预存（0，-1）<hr/>
 * 可以移除0长子数组，这意味着整除了<hr />
 * 不能全部移除，这样的情况请返回-1 <hr />
 *
 * @author Yabo
 * @date 2024/06/17
 */
class lc1590_MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        // 1. 请计算全体的余数mod，如果为0，则返回0，意为已经整除
        int mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0) {
            return 0;
        }
        // 2. 创建map，所存关系对（前缀和模p的余数，最新的位置（意味需要实时更新））
        HashMap<Integer, Integer> map = new HashMap<>();
        // 3. 预存（0，-1）
        map.put(0, -1);
        // 4. 初始化答案寄存器，求最小，则初始化为极大值
        int ans = Integer.MAX_VALUE;
        // 5. for循环，求当前前缀和的余数，接着寻找在余数水平上相差一个mod的前缀和余数（这里请独立思考当当前前缀和的余数>mod和<mod的两种情况，
        // 之所以可以这样，是因为从相差一个mod的前缀和余数到当前前缀和的余数的过程，余数是总体上递增的），
        // 如找到，请通过map获取其下标，后取max，随后及时更新当前前缀和的余数及其所对应下标。
        for (int i = 0, cur = 0; i < nums.length; i ++){
            cur = (cur + nums[i]) % p;
            int target = (cur - mod + p) % p;
            if (map.containsKey(target)){
                ans = Math.min(ans, i - map.get(target));
            }
            map.put(cur, i);
        }
        // 6. 返回答案，但是得根据题意额外判断。
        return ans == nums.length ? -1 : ans;
    }
}
