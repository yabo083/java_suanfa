package com.acwing.base;

import java.io.*;

// 似乎更优？
public class acwing889_2 {

    public static int mod = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int a = n * 2, b = n;
        long res = 1, b1 = 1;
        for (int i = 0; i < b; i++) {
            res = res * (a - i) % mod;
            b1 = b1 * (i + 1) % mod;
        }

        res = res * qmi(b1, mod - 2, mod) % mod;
        res = res * qmi(n + 1, mod - 2, mod) % mod;

        sc.write(res);
        sc.pw.flush();
    }

    private static long qmi(long a, int k, int p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * a % p;
            }
            a = a * a % p;
            k >>= 1;
        }
        return res;
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
