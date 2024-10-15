package com.leetcode;

public class lc1047_RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        int i = 0, j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                s = s.substring(0, i) + s.substring(j + 1);
                i = 0;
                j = 1;
                continue;
            }
            i++;
            j++;
        }
        return s;
    }

    public static String removeDuplicates2(String s) {
        int n = s.length();
        char[] stack = new char[10001];
        char[] str = s.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j == 0 || stack[j - 1] != str[i]) {
                stack[j++] = str[i];
            } else {
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < j; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates2("abbaca"));
        System.out.println(removeDuplicates2("azxxzy"));
        System.out.println(removeDuplicates2("aaaaaaaaa"));



    }

}
