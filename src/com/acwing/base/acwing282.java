package com.acwing.base;

import java.io.*;

public class acwing282 {

    public static int N = 310;

    public static int n;

    public static int[] s = new int[N];

    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            s[i] += s[i - 1];
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                f[l][r] = 0x3f3f3f3f;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }

        sc.write(f[1][n]);
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
