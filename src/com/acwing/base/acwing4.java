package com.acwing.base;

import java.io.*;

public class acwing4 {

    public static int N = 110;
    public static int n, m;
    public static int[] f = new int[N];
    public static int[] vv = new int[700], ww = new int[700];


    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        int num = 1;
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), s = sc.nextInt();
            for (int j = 1; j <= s; j <<= 1) {
                vv[num] = j * v;
                ww[num++] = j * w;
                s -= j;
            }
            if (s != 0) {
                vv[num] = s * v;
                ww[num++] = s * w;
            }
        }
        for (int i = 1; i < num; i++) {
            for (int j = m; j >= vv[i]; j--) {
                f[j] = Math.max(f[j], f[j - vv[i]] + ww[i]);
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
