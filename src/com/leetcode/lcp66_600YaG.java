package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class lcp66_600YaG {

    public static int minNumBooths(String[] demand) {

        HashMap<Character, Long> resultMap = new HashMap<>();

        for (String str : demand) {
            Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            collect.forEach((key, value) -> {
                resultMap.merge(key, value, Math::max);
            });
        }

        return (int) resultMap.values().stream().mapToLong(Long::longValue).sum();

    }

    public static int minNumBooths2(String[] demand) {
        int[] result = new int[26];
        for (String s : demand) {
            char[] chars = s.toCharArray();
            int[] tmp = new int[26];
            for (char aChar : chars) {
                tmp[aChar - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                result[i] = Math.max(tmp[i], result[i]);
            }
        }
        int ans = 0;
        for (int j : result) {
            ans += j;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(minNumBooths(new String[]{"acd", "bed", "accd"}));
        System.out.println(minNumBooths2(new String[]{"acd", "bed", "accd"}));
        System.out.println(minNumBooths(new String[]{"abc", "ab", "ac", "b"}));
        System.out.println(minNumBooths2(new String[]{"abc", "ab", "ac", "b"}));
    }


}
