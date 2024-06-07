package com.leetcode;

class lc394_DecodeString {

    public static int where;

    public String decodeString(String s) {
        // 1. 重新初始化全局变量
        where = 0;
        // 2. 返回调用递归函数的结果
        return f(s.toCharArray(), 0);
    }

    public static String f(char[] s, int i) {
        // 1. 数字寄存器cnt
        int cnt = 0;
        // 2. 路径记录path初始化x
        StringBuilder path = new StringBuilder();
        // 3. while循环，如果没走到负责的区间尾 或 步进指针没指向一个右中括号：总之就是没到结束的时候，就得继续循环
        while (i < s.length && s[i] != ']') {
            // 4. 如果是字母，那就添加到path里
            if (Character.isAlphabetic(s[i]))
                path.append(s[i ++]);
            // 5. 如果是是数字，那就寄存到cnt里
            else if (Character.isDigit(s[i]))
                cnt = cnt * 10 + s[i ++] -'0';
            // 6. 最后就只剩遇到左中括号的情况了，此时path得添加递归调用子函数后获得的结果；随后，步进指针赋值为已经更新的全局变量+1，cnt计数也得归零
            else {
                path.append(get(cnt,f(s, i + 1)));
                i = where + 1;
                cnt = 0;
            }
        }
        // 7. while循环结束，更新全局变量，返回path中记录的字母序列
        where = i;
        return path.toString();
    }

    public static String get(int cnt, String str) {
        // 1. 只是一个cnt是多少，就把str重复几次并返回的函数罢了
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cnt; i ++)
            res.append(str);
        return res.toString();
    }
}
