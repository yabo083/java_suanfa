package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * 间杂有许多重复字符的字符串，
 * 要去重，且结果字符串字典序最小
 *
 * @author Yabo
 * @date 2024/07/03
 */
class lc316_RemoveDuplicateLetters {

    public static int MAXN = 26;

    // 每种字符词频
    public static int[] cnts = new int[MAXN];

    // 每种字符目前有没有进栈
    public static boolean[] enter = new boolean[MAXN];

    // 单调栈
    public static char[] stack = new char[MAXN];

    public static int r;

    public String removeDuplicateLetters(String s) {
        // 1. 初始化栈
        r = 0;
        // 2. 初始化词频统计数组和指示灯数组
        Arrays.fill(cnts, 0);
        Arrays.fill(enter, false);
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnts[c - 'a']++;
        }
        // 3. 增强for循环，过程简述：
        for (char cur : cs) {
            //     1. 遇到字典序较小的、还没上车的字符，想要入栈怎么办？
            //     如果后面还能上车，就把前面的依次请出来，直到这个小字典序的字符入栈，
            if (!enter[cur - 'a']) {
                // 此处注意cnts数组到底该接受一个怎样的参数，直接放原字符可不行！
                while (r > 0 && stack[r - 1] > cur && cnts[stack[r - 1] - 'a'] > 0) {
                    enter[stack[--r] - 'a'] = false;
                }
                stack[r++] = cur;
                enter[cur - 'a'] = true;
            }
            //     2. 已经入栈的字符，想要重复入栈怎么办？
            //     拒绝！（直接跳过看下一个）
            //     但是注意：无论是跳过，还是弹出计入，都会消耗当前字符的词频。
            cnts[cur - 'a']--;

        }
        // 4. 栈内容转字符串，返回
        return String.valueOf(stack, 0, r);
    }
}
