package com.leetcode;

import java.util.Arrays;

/**
 * LC JF1JUT 外星人词典
 *
 * @author Yabo
 * @date 2024/09/03
 */
class lcJf1JuT_AlienDictionary {

    public static int N = 700;

    public static int n, m, idx;

    public static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[26], q = new int[26];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static String alienOrder(String[] words) {
        // 1. 点从0开始计数
        idx = 1;
        // 2. 初始化
        Arrays.fill(d, -1);
        Arrays.fill(h, -1);
        // 3. 遍历每个单词的每个字符，只要出现不管几次，标为0即可。
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                d[word.charAt(j) - 'a'] = 0;
            }
        }
        // 4. for循环
        for (int i = 0, j, len; i < words.length - 1; i++) {
            // 	1. 取当前单词
            String cur = words[i];
            // 	2. 取下一个单词
            String next = words[i + 1];
            // 	3. 设置j=0
            j = 0;
            // 	4. 比较两个单词，取其长度较小的那个设置len
            len = Math.min(cur.length(), next.length());
            // 	5. for循环
            for (; j < len; j++) {
                // 		1. 取两个单词的字符逐一比较，如果不等又根据其顺序，
                // 		可得火星文字符字典序。
                if (cur.charAt(j) != next.charAt(j)) {
                    // 		2. 于是加边，方向cur.j->next.j
                    add(cur.charAt(j) - 'a', next.charAt(j) - 'a');
                    d[next.charAt(j) - 'a']++;
                    // 		3. break;
                    break;
                }
            }
            // 	6. 特判：如果j未达cur末尾，但已达next某位
            // 	可直接判定不合法，返回""即可。
            if (j < cur.length() && j == next.length()) {
                return "";
            }
        }

        // 5. 用for借助入度表收集出现字符种类kinds
        // 同时收集入度为0的点把它们入q。
        int kinds = 0, l = 0, r = 0;
        for (int i = 0; i < 26; i++) {
            if (d[i] != -1) {
                kinds++;
            }
            if (d[i] == 0) {
                q[r++] = i;
            }
        }

        // 6. 准备构建答案ans
        StringBuilder ans = new StringBuilder();
        while (l < r) {
            int cur = q[l++];
            ans.append((char) (cur + 'a')); // TODO: 确定好你要强转的对象！不加括号会出事的！
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    q[r++] = j;
                }
            }

        }
        // 7. 返回ans.toString()，如果ans的长度等于kinds，
        // 说明该出现的都出现了，否则返回""。
        return ans.length() == kinds ? ans.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}
