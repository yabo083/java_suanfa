package com.acwing.base;

import java.io.*;

public class acwing854 {

    public static int N = 210, INF = 0x3f3f3f3f;

    public static int n, m;

    public static int[][] d = new int[N][N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        int Q = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = INF;
                }
            }
        }

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            d[a][b] = Math.min(d[a][b], c);
        }

        floyd();

        while (Q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            int t = d[a][b];
            if (t > INF / 2) {
                sc.write("impossible\n");
            } else {
                sc.write(t+"\n");
            }
        }

        sc.pw.flush();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
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
