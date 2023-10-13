package com.acwing.base;

import java.io.*;
import java.math.BigInteger;

public class acwing888 {

    public static int N = 5010, cnt;
    public static int[] primes = new int[N], sum = new int[N];

    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        int a = sc.nextInt(), b = sc.nextInt();

        get_primes(a);

        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = get(a, p) - get(b, p) - get(a - b, p);
        }

        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            for (int j = 0; j < sum[i]; j++) {
                res = res.multiply(BigInteger.valueOf(p));
            }
        }
        sc.write(res);
        sc.pw.flush();
    }

    private static int get(int n, int p) {
        int res = 0;
        while (n > 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }

    private static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
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
