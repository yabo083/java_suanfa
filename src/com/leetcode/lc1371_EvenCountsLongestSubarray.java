package com.leetcode;

import java.util.Arrays;

/**
 * 求包含偶数次元音的最长子字符串
 *
 * 使用：元音的状态数组，奇数+偶数=奇数，偶数+偶数=偶数
 *
 * 核心：如果一个状态前后出现两次，说明经过的中间一段的元音个数是偶数。
 *
 * @author Yabo
 * @date 2024/06/17
 */
class lc1371_EvenCountsLongestSubarray {

    public int findTheLongestSubstring(String s) {
        // 1. 获取字符串原长
        int n = s.length();
        // 2. 创建元音的状态数组（因为元音只有五个，所以2^5=32）
        int[] map = new int[32];
        // 3. 全填充-2，代表真没
        Arrays.fill(map, -2);
        // 4. 0位置填充-1，代表一种潜规则（它可以代表一种状态，但实际也没意义）
        map[0] = -1;
        // 5. 创建答案寄存器
        int ans = 0;
        // 6. for循环，取一个字符，根据元音决定左移位数，不是元音不移动
        for (int i = 0, status = 0; i < n; i++) {
            int m = move(s.charAt(i));
            if (m != -1) {
                status ^= 1 << m;
            }
            // 7. 每步进一次，就在数组中查找相同的状态，如果有，就获取其下标，和之前的取个max，
            if (map[status] != -2) {
                ans = Math.max(ans, i - map[status]);
            } else {
                map[status] = i;
            }
        }
        // 8. 没有就存入当前位置的下标
        return ans;
    }

    private int move(char c) {
        switch (c){
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}
