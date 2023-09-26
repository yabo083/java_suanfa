package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing858 {

    public static final int INF = 0x3f3f3f3f;
    public static int N = 510;

    public static int n, m;

    public static int[][] g = new int[N][N];

    public static int[] dist = new int[N];

    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int[] row : g) {
            Arrays.fill(row, INF);
        }

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int t = prim();

        if (t == INF) {
            sc.write("impossible");
        } else {
            sc.write(t);
        }
        sc.pw.flush();


    }

    private static int prim() {
        Arrays.fill(dist, INF);

        dist[1] = 0;

        int res = 0;

        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && dist[t] > dist[j]) {
                    t = j;
                }
            }

            if (dist[t] == INF) {
                return INF;
            }

            res += dist[t];

            st[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
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
