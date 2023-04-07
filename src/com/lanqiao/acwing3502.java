package com.lanqiao;


import java.io.*;
import java.util.HashSet;


public class acwing3502 {

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static final int N = 10;
    static int n, m ,k;
    static int[][] g = new int[N][N];
    static HashSet<Integer> set = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int u, int num) {
        if (u == n) set.add(num);
        else {
            for (int i = 0; i < 4; i ++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < n)
                    dfs(x, y, u + 1, num * 10 + g[a][b]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                g[i][j] = sc.nextInt();

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                dfs(i, j, 0, g[i][j]);

        sc.write(set.size());

    }


}
