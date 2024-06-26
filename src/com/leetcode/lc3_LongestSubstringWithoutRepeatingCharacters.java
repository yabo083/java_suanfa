package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：找出一个字符串中的最长无重复字符子串
 * <br>
 * l和r都是在s上滑动的，s[l]、s[r]可以取字符。
 *
 * @author Yabo
 * @date 2024/06/25
 */
class lc3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 1. 先转char数组
        char[] chars = s.toCharArray();
        // 2. 获取其长度
        int n = chars.length;
        // 3. 根据特性，可将每一个字符都映射到一个唯一的数字上，这样就形成了一个由代表字符们的数字充当下标的数组。
        // 则其值为几，在这道题中就代表出现在字符数组的哪个位置！
        int[] last = new int[256];
        // 4. 先填充-1，代表还没出现
        Arrays.fill(last, -1);
        // 5. 创建答案寄存器
        int ans = 0;
        // 6. for循环，还是以r为准的滑动窗口，
        // 流程大致：
        // 先更新l：如果r处的字符没出现过，那么根据巧妙的计算得知，+1也是0，
        // 所以l停在原地;如果出现过，那么l就要跳到上次出现的位置的下一个位置，
        // 至于为什么，这便是这道题的关键了：因为要找没重复的嘛！
        // 后更新答案，啊，简单的max，顺带一提长度计算仍然是r-l+1
        // 最后更新用来映射的字符数组，其实就是把r处的字符出现位置记录到映射数组里。
        for (int l = 0, r = 0; r < n; r ++) {
            l = Math.max(l, last[chars[r]] + 1);
            ans = Math.max(ans, r - l + 1);
            last[chars[r]] = r;
        }
        // 7. 返回ans
        return ans;
    }
}
