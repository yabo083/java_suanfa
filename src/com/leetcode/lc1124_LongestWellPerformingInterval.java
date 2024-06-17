package com.leetcode;

import java.util.HashMap;

/**
 * 表现良好的最长时间段
 * 一级概念：「劳累的天数」、「不劳累的天数」
 * 二级概念：表现良好时间段：「劳累的天数」 > 「不劳累的天数」
 *
 * 求：表现良好时间段的 max length
 *
 * @author Yabo
 * @date 2024/06/17
 */
class lc1124_LongestWellPerformingInterval {

        public int longestWPI(int[] hours) {
            // 1. 起手hashmap，存储关系对（前缀和，最早出现的位置（意味着只存最早一次））
            HashMap<Integer, Integer> map = new HashMap<>();
            // 2. 预存（0，-1）
            map.put(0, -1);
            // 3. 创建答案寄存器
            int ans = 0;
            // 4. for循环，计算逐步累加和，并转义（大于8为1，小于8为-1）
            for (int i = 0, sum = 0; i < hours.length; i++) {
                sum += hours[i] > 8 ? 1 : -1;
                // 5. 如果步进指针当前的前缀和大于0，那么长度就是从头开始到现在
                if (sum > 0) {
                    ans = i + 1;
                } else {
                    // 6. 如果……小于0，那么在map中寻找比当前前缀和还小1的存在（理由：由小一到当前，必然是+了1，那么之间经过的这一段，必定是一个符合二级概念的区间），获取其下标，计算其长度，与之前所存，取个max。
                    if (map.containsKey(sum - 1)) {
                        ans = Math.max(ans, i - map.get(sum - 1));
                    }
                }
                // 7. 当前的前缀和没在，再放入map中
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            // 8. 返回答案
            return ans;
        }
}
