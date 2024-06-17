package com.leetcode;

import java.util.HashMap;

class lc560_NumberOfSubarraySumEqualsAim {

    public int subarraySum(int[] nums, int k) {
        // 1. hashmap起手，所存关系对的意义是：（（前缀和），出现次数）
        HashMap<Integer, Integer> map = new HashMap<>();
        // 2. 提前放（0,1）
        map.put(0, 1);
        // 3. 创建答案寄存器
        int ans = 0;
        // 4. for循环，遍历数组。
        for (int i = 0, sum = 0; i < nums.length; i ++) {
            // 核心思想就是，步进指针前进一次，就找一次满足目标值的子数组，而之前讨论过，找子数组的问题可以被转换成：找第一次出现（当前前缀和-目标值）的前缀和的下标，所以要做的就是每步进一次，就找一次下标。
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            // 5. 至于怎么存关系，也是每步进一次，就存一次。值得注意的是，同一个位置可能被之后的多个子数组选做起点，试想，当步进至i=5的位置，i=2满足要求；当步进至i=7的位置，i=2同样满足要求。显然, [5,7]这一段的前缀和并未长进, 值相等。
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // 6. 返回答案。
        return ans;
    }
}
