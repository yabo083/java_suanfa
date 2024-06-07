package com.leetcode;

import java.util.TreeMap;

class lc726_NumberOfAtoms {

    public static int where;

    public String countOfAtoms(String formula) {
        // 1. 全局变量初始化
        where = 0;
        // 2. 初始化一个TreeMap来符合字典序
        TreeMap<String, Integer> ans = f(formula.toCharArray(), 0);
        // 3. StringBuilder承接，最后输出
        StringBuilder res = new StringBuilder();
        for (String tmp : ans.keySet()) {
            res.append(tmp);
            int cnt = ans.get(tmp);
            if (cnt > 1)
                res.append(cnt);
        }
        return res.toString();
    }


    public static TreeMap<String, Integer> f(char[] s, int i) {
        // 1. 一个总TreeMap,记录各原子数目
        TreeMap<String, Integer> ans = new TreeMap<>();
        // 2. 一个原子序列，记录独立原子名称
        StringBuilder name = new StringBuilder();
        // 3. 一个原子团TreeMap，记录原子团中个原子数目
        TreeMap<String, Integer> pre = new TreeMap<>();
        // 4. 一个计数器，专门用来记录分子式中出现的数字，在很多地方有用，在很多地方计算方法都不同。
        int cnt = 0;
        // 5. while循环，当步进指针没到区间结尾，且没遇到右括号时，就一直循环
        while ( i < s.length &&  s[i] != ')') {
            // 6. 如果当前指针所指是大写字母或左括号，那就等整理统计下之前的原子数；随后再具体分辨到底是大写字母还是左括号；
            //     是大写字母就添加至大写字母尾端；是左括号就代表有原子团，递归调用，并将结果存入原子团TreeMap中
            if ('A' <= s[i] && s[i] <= 'Z' || s[i] == '('){
                fill(ans, name, pre, cnt);
                name.setLength(0);
                pre = null;
                cnt = 0;
                if ('A' <= s[i] && s[i] <= 'Z')
                    name.append(s[i ++]);
                else {
                    pre = f(s, i + 1);
                    i = where + 1;
                }
            }
            // 7. 如果是小写字母，那肯定是像Fe这种，和之前的大写字母是一起的，所以直接加上就好（所以可以看出name最多也就有1个或2个字母）
            else if ('a' <= s[i] && s[i] <= 'z')
                name.append(s[i ++]);
            // 8. 最后的可能只剩数字，那就存入计数器里就好。
            else {
                cnt = cnt * 10 + s[i ++] - '0';
            }
        }
        // 9. while结束了，将没来得及整理的整理下，随后更新全局变量，返回总TreeMap
        fill(ans, name, pre, cnt);
        where = i;
        return ans;
    }

    public static void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt) {
        // 1. 如果原子序列不为空或原子团不为空，那就请进
        if (name.length() > 0 || pre != null) {
            // 2. 先看下计数器，如果是0，其实是1；如果不是0，那就是本来（该死的省略）
            cnt = cnt == 0 ? 1 : cnt;
            // 3. 如果是原子序列不为0，那就将原子序列存入总TreeMap中
            if (name.length() > 0){
                String tmp = name.toString();
                ans.put(tmp, ans.getOrDefault(tmp, 0) + cnt);
            } else {
                // 4. 之后就只剩原子团不为空的情况了，一个一个的加进去就行，只需注意此时计数器和原子团内部的原子是乘的关系就好。
                for (String tmp : pre.keySet()) {
                    ans.put(tmp, ans.getOrDefault(tmp, 0) + pre.get(tmp) * cnt);
                }
            }
        }
    }
}
