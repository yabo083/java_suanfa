package com.lanqiao;

import java.io.*;
import java.util.*;


public class acwing844 {

    static class PII {
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;

    }

    static int N = 110, n, m;

    static int[][] g = new int[N][N], d = new int[N][N];

    static int bfs() {
        Queue<PII> q = new LinkedList<>();

        for (int[] row : d)
            Arrays.fill(row, -1);


        d[0][0] = 0;

        q.add(new PII(0, 0));


        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        while (q.size() != 0) {

            PII t = q.remove();

            for (int i = 0; i < 4; i++) {

                int x = t.x + dx[i], y = t.y + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {

                    d[x][y] = d[t.x][t.y] + 1;
                    q.add(new PII(x, y));
                }

            }
        }
        return d[n - 1][m - 1];
    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.print(o);
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++)
                g[i][j] = sc.nextInt();

        sc.write(bfs());
    }
}
