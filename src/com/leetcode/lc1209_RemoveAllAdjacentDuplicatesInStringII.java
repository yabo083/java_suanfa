package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1209_RemoveAllAdjacentDuplicatesInStringII {

    public static String removeDuplicates(String s, int k) {
        char[] stack = new char[100001];
        int p = 0;
        int[] counter = new int[27];
        int i = 0;
        while (i < s.length()) {
            char charAt = s.charAt(i++);
            int alpha = charAt - 'a';

            if (counter[alpha] + 1 < k) {
                counter[alpha]++;
                stack[p++] = charAt;
            } else {
                // 连续向前检查k个数，看是否相等
                int skip = 0;
                for (int idx = 1; idx < k; idx++) {
                    if (charAt != stack[p - idx]) {
                        skip = 1;
                        counter[alpha]++;
                        stack[p++] = charAt;
                        break;
                    }
                }
                if (skip == 0) {
                    p -= (k - 1);
                    counter[alpha] -= (k - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < p; j++) {
            sb.append(stack[j]);
        }
        return sb.toString();
    }

    public static String removeDuplicates2(String s, int k) {
        class pair {

            char c;
            int count;

            public pair(char c, int count) {
                this.c = c;
                this.count = count;
            }
        }

        int n = s.length();
        Deque<pair> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peekLast().c == s.charAt(i)) {
                stack.peekLast().count++;
                if (stack.peekLast().count == k) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(new pair(s.charAt(i), 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            pair pair = stack.removeLast();
            sb.append(String.valueOf(pair.c).repeat(pair.count));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abcd", 2));
        System.out.println(removeDuplicates2("deeedbbcccbdaa", 3)); // counter[alpha] + 1 < k
        System.out.println(removeDuplicates2("pbbcggttciiippooaais", 2)); // p -= (k - 1);
        System.out.println(removeDuplicates2("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4)); // skip
        System.out.println(removeDuplicates2("dtpdtaaaaaaaaaaaaaaaaaaaxxxxxxxxxxxxxxxxxxxxatdwvvpctpajaggl",
            20)); // counter[alpha] -= (k - 1);

    }

}
