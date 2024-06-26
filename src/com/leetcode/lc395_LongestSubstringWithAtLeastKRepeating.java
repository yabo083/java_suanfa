package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * <br>
 * 算了我不理解。
 * <br>
 * 通过增加限制，来创造单调性。
 * <hr>
 * 找最长子串，里面的字符凡出现就得达到k，且越大越好
 * <br>
 * 自然可以分情况，只有1种字符的最长子串是多长？2种3种呢？？
 *
 * @author Yabo
 * @date 2024/06/26
 */
class lc395_LongestSubstringWithAtLeastKRepeating {

    public int longestSubstring(String s, int k) {
        // 1. 创建字符串的字符数组
        char[] sChars = s.toCharArray();
        // 2. 获取其长度
        int n = sChars.length;
        // 3. 创建字符映射数组
        int[] map = new int[26];
        // 4. 创建答案变量
        int ans = 0;
        // 5. 外层for循环，用于限制每次讨论的字符种类，
        // 题目特设，s只有小写字母构成，这就给了我们讨论的空间
        for (int require = 1; require <= 26; require++) {
            Arrays.fill(map, 0);
            // 6. 内存for循环，流程概述：
            for (int l = 0, r = 0, kinds = 0, meets = 0; r < n; r++) {
                //     1. 不分由说先将r处字符纳入映射数组
                map[sChars[r] - 'a']++;
                //     2. 随后如果是新种类的字符，那么种类变量++
                if (map[sChars[r] - 'a'] == 1) {
                    kinds++;
                }
                //     3. 如果是旧种类的字符，且数量已达标，那么达标变量++
                if (map[sChars[r] - 'a'] == k) {
                    meets++;
                }
                //     （注意，达标后该类型字符仍可增长其数量！）
                //     4. while循环，专用来剔除种类变量大于限制的情况
                while (kinds > require) {
                    //         1. 如果左端点代表的字符出现次数刚好是1，
                    //         那就轻松，说明剔除之后窗口内的种类就少了一个，
                    //         种类变量直接可--
                    if (map[sChars[l] - 'a'] == 1) {
                        kinds--;
                    }
                    //         2. 如果左端点代表的字符出现次数是k，
                    //         那么剔除之后，达标的字符将少一个，
                    //         虽然很可惜，但不得不将此时达标变量--
                    if (map[sChars[l] - 'a'] == k) {
                        meets--;
                    }
                    //         3. 终于该剔除左端点了。
                    map[sChars[l++] - 'a']--;
                }
                //     5. 如果此时达标变量 == 限制，则更新答案变量。
                if (meets == require) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        // 7. 返回答案变量
        return ans;
    }
}
