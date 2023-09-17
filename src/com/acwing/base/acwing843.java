package com.acwing.base;

import java.io.*;

public class acwing843 {

    public static int N = 20;

    public static int n = 0;

    public static char[][] g = new char[N][N];

    public static boolean[] col = new boolean[N], dg = new boolean[N], udg = new boolean[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sc.write(g[i][j]);
                }
                sc.write("\n");
            }
            sc.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) { // dg is Bottom left to top right，udg is Top left to bottom right
                g[u][i] = 'Q';
                col[i] = dg[u - i + n] = udg[u + i] = true;
                dfs(u + 1);
                col[i] = dg[u - i + n] = udg[u + i] = false;
                g[u][i] = '.';
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
