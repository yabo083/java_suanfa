package com.acwing.base;

import java.io.*;

public class acwing898 {

    public static int N = 510;
    public static int n;
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                f[i][j] += Math.max(f[i + 1][j], f[i + 1][j + 1]);
            }
        }

        sc.write(f[1][1]);
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
