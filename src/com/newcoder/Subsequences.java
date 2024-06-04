package com.newcoder;

import java.util.HashSet;

public class Subsequences {

    public String[] generatePermutation (String s) {
        // 1. 为方便处理，先转成字符数组
        char[] str = s.toCharArray();
        // 2. 为了去重，先初始化一个hashset
        HashSet<String> set = new HashSet<>();
        // 3. 调用子函数
        f2(str,0, new char[str.length], 0, set);
        // 4. 一些输出事宜
        String[] ans = new String[set.size()];
        int i = 0;
        for(String cur : set) {
            ans[i ++] = cur;
        }
        return ans;
    }

    public static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
        // 1. 如果已经遍历到最后一个，就把已记录在path中的字符串添加至set
        if (i == s.length){
            set.add(String.valueOf(path, 0, size));
        } else {
            // 2. 如果还处于半路，那就先将当前的字符计入path，随后分为算上和不算递归，over!
            path[size] = s[i];
            f2(s, i + 1, path, size + 1, set);
            f2(s, i + 1, path, size, set);
        }
    }
}
