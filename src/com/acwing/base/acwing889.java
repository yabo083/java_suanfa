package com.acwing.base;

import java.io.*;

public class acwing889 {

    public static long mod = (long) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        long[] x = {0}, y = {0};
        int a = n * 2, b = n;
        long res = 1;
        for (int i = a; i > a - b; i--) {
            res = res * i % mod;
        }
        long bt = 1;
        for (int i = 2; i <= b; i++) {
            bt = bt * i % mod;
        }
        exgcd(bt, mod, x, y);
        res = res * x[0] % mod;
        exgcd(n + 1, mod, x, y);
        res = (res * x[0] % mod + mod) % mod;
        sc.write(res);
        sc.pw.flush();
    }

    private static long exgcd(long a, long b, long[] x, long[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        long d = exgcd(b, a % b, y, x);
        y[0] -= a / b * x[0];
        return d;
    }
    public static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }
}
