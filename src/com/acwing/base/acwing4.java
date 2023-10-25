package com.acwing.base;

import java.io.*;

public class acwing4 {

    public static int N = 110;
    public static int n, m;
    public static int[] v = new int[N], w = new int[N], s = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[j] = Math.max(f[j], f[j - v[i] * k] + w[i] * k);
                }
            }
        }
        sc.write(f[m]);
        sc.pw.flush();
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
