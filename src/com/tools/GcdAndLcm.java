package com.tools;

public class GcdAndLcm {

    //求最大公约数
    public static int gcd1(int a, int b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    //求最小公倍数
    public static int lcm(int a, int b) {
        return a / gcd1(a, b) * b;
    }

    //Stein算法（结合辗转相除法和更相减损法的优势以及移位运算）求最大公约数
    public static int gcd2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a % 2 == 0 && b % 2 == 0) return 2 * gcd2(a >> 1, b >> 1);
        else if (a % 2 == 0) return gcd2(a >> 1, b);
        else if (b % 2 == 0) return gcd2(a, b >> 1);
        else return gcd2(Math.abs(a - b), Math.min(a, b));
    }
}
