package com.leetcode;

public class lc29 {

    public static int min = Integer.MIN_VALUE;

    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int neg(int n) {
        return add(~n, 1);
    }

    public static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    public static int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    public static void main(String[] args) {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        // test divide method and / method
        for (int i = 0; i < testTimes; i++) {
            int a = (int) (Math.random() * n) - (int) (Math.random() * n);
            int b = (int) (Math.random() * n) - (int) (Math.random() * n);
            if (b == 0) {
                continue;
            }
            if (a / b != new lc29().divide(a, b)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    public int divide(int dividend, int divisor) {
        if (dividend == min && divisor == min) {
            return 1;
        }

        if (dividend != min && divisor != min) {
            return div(dividend, divisor);
        }

        if (divisor == min) {
            return 0;
        }

        if (divisor == neg(1)) {
            return Integer.MAX_VALUE;
        }

        dividend = add(dividend, divisor > 0 ? divisor : neg(divisor));
        int ans = div(dividend, divisor);
        int offset = divisor > 0 ? neg(1) : 1;
        return add(ans, offset);
    }
}



