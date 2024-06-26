package com.leetcode;

/**
 * 题意理解：
 * <br>
 * 在长串里找短串，只不过找到的串只需有短串的所有字符，
 * <br>
 * 而不必在意顺序或者额外字符混进去的之类的条件。
 * <br>
 * 我觉得有空可以模拟下，代码在找到第一个覆盖子串后，
 * <br>
 * 找第二个的过程感觉就完全不同了。
 * <br>
 * 当然，觉得神奇可能是我没理解到位。
 *
 * @author Yabo
 * @date 2024/06/26
 */
class lc76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // 0. 特判：如果s串长度小于t串，直接返回空串
        if (s.length() < t.length()) {
            return "";
        }
        // 1. 将两个串转换为字符数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 2. 创建以所有字符对应一个数字，为下标的映射数组，其长为256，
        // 其初始值0的意义为无欠债。
        int[] map = new int[256];
        // 3. 随后，对t中含有的字符，进行欠债处理，即t中不同字符出现几次，
        // 那map数组对应的位置就自减几次
        for (char tmp : tChars) {
            map[tmp]--;
        }
        // 4. 创建最短子串的长度这一变量和最短子串的起始位置这一变量，
        // 为了方便从s串中截取最后的答案
        int len = Integer.MAX_VALUE;
        int start = 0;
        // 5. for 循环开始，
        // 流程简介：
        //     1.用r遍历s中的每个字符，不分由说地使其++，对于原始值为负的情况，
        // 此时就可以偿还负债，即不仅已使映射数组对应值++，还对总负债值--
        //     2. 每次检查总负债值，何时归零，即代表已找到一个覆盖了t的子串，
        //     到底是不是最短，还需从l处剔除还错的款项（tmd我欠的是房租，你给我车贷是吧！？）
        //     一个显而易见的特征是，映射数组全部值为0，才是无负债，
        //     所以，但凡有某个值>0，那就是可以剔除的。
        //     但是要注意，剔除只能从l开始，一个个进行，
        //     如果有一个失败，即使后面还有些也应该剔除的，只能忍受不理。
        //     而不能凡是>0就剔，
        //     因为我们要的是子串，而不是子序列。
        //     最后就是计算长度和起始点了，长度比上一次找到的短才更新，
        //     不然就忽略。
        for (int l = 0, r = 0, debt = tChars.length; r < sChars.length; r ++){
            if (map[sChars[r]] ++ < 0)
                debt --;
            if (debt == 0){
                while (map[sChars[l]] > 0)
                    map[sChars[l ++]] --;
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        // 6. 返回最短覆盖子串；如果len仍为初始值，那么请返回一个空串。
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
