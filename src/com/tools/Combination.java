package com.tools;

public class Combination {


    /**
     * 计算组合数
     * @param a 是n
     * @param b 是m
     * @return 返回结果
     */
    public static long C(long a, long b) {
        long res = 1;
        for (long i = a, j = 1; j <= b; i--, j++) {
            res = res * i / j;
//            if (res > n) return res;//特殊时候有用
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(C(1000000000, 2));
    }
}
