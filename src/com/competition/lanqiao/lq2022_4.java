package com.competition.lanqiao;

public class lq2022_4 {

    public static long lcm(long a, long b) {
        return a / gcd1(a, b) * b;
    }

    //求最大公约数
    public static long gcd1(long a, long b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    public static void main(String[] args) {
        int[] mod = {0, 0, 1, 2, 1, 4, 5, 4, 1, 2, 9, 0, 5, 10, 11, 14, 9, 0, 11, 18, 9, 11, 11, 15, 17, 9, 23, 20, 25, 16, 29, 27, 25, 11, 17, 4, 29, 22, 37, 23, 9, 1, 11, 11, 33, 29, 15, 5, 41, 46};
        long res = 2 + mod[2];
        long k = 2;
        for (int i = 3; i < 50; i ++){
            while (true){
                if (res % i == mod[i]) {
                    k = lcm(k, i);
                    break;
                }
                else {
                    res += k;
                }
            }
        }
        System.out.println(res);
    }
}
