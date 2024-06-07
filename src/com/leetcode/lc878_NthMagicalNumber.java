package com.leetcode;

class lc878_NthMagicalNumber {
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public int nthMagicalNumber(int n, int a, int b) {
        // 1. 经过一通分析，确定的了第n个神奇数是在[1,n*Math.min(a,b)]之间的!
        // 2. 所以可以使用二分+容斥，所以需要a和b的lcm
        long lcm = lcm(a, b);
        // 3. 初始化答案寄存器
        long ans = 0;
        // 4. 循环二分开始了，以后就用这个<=的版本了，感觉清晰易懂
        for (long l = 0, r = (long) n * Math.min(a, b); l <= r;) {
            long m = (l + r) / 2;
            if (m/a + m/b - m/lcm >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // 5. 返回时，记得模和强转成int
        return (int) (ans % 1000000007);
    }
}
