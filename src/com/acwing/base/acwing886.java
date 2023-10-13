package com.acwing.base;

import java.io.*;

public class acwing886 {

    public static int N = 100010, mod = (int) (1e9 + 7);

    public static int[] fact = new int[N], infact = new int[N];

    public static void main(String[] args) throws IOException {
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
            infact[i] = (int) ((long) infact[i - 1] * qmi(i, mod - 2, mod) % mod);
        }

        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            sc.write((long) fact[a] * infact[b] % mod * infact[a - b] % mod + "\n");
        }
        sc.pw.flush();
    }

    private static int qmi(int a, int k, int p) {
        int res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = (int) ((long) res * a % p);
            }
            a = (int) ((long) a * a % p);
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

