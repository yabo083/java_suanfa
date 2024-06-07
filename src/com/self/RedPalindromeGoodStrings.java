package com.self;

public class RedPalindromeGoodStrings {

    public static int num1(int n) {
        // 0. 这次应该不能当正式答案放上去，所以只起一个找规律的作用
        // 1. 初始化一个状态数组
        char[] path = new char[n];
        // 2. 直接返回调用子函数的结果
        return f(path, 0);
    }

    public static int f(char[] path, int i) {
        // 1. 凡是递归，都得先设计递归终止条件：如果此时状态数组已满，则去遍历所有长度大于1的子串，不过只算有一个回文串的串，其余忽略
        if (i == path.length){
            int cnt = 0;
            for (int j = 0; j < path.length; j ++)
                for (int k = j + 1; k < path.length; k ++){
                    if (is(path, j, k))
                        cnt ++;
                    if (cnt > 1) {
                        return 0;
                    }
                }
            return cnt == 1 ? 1 : 0;
        } else {
            // 2. 正常情况：把每个位置都用三个字符试一遍，然后每试一遍递归一遍，最后返回答案。
            int ans = 0;
            path[i] = 'r';
            ans += f(path, i + 1);
            path[i] = 'e';
            ans += f(path, i + 1);
            path[i] = 'd';
            ans += f(path, i + 1);
            return ans;
        }
    }

    public static boolean is(char[] s, int l, int r) {
        // 1. 最简单的数组判断回文串你不会不会吧？？
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

    public static int num2(int n) {
        // 1. 找规律喽
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 3;
        } else if (n == 3) {
            return 18;
        } else
            return (int) ((6L * (n + 1)) % 1000000007);

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("长度为" + i + ", 答案:" + num1(i));
        }
    }

}
