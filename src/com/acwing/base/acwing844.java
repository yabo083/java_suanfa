package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class acwing844 {

    public static int N = 110;
    public static int n, m;
    public static int[][] g = new int[N][N], d = new int[N][N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        sc.write(bfs());
        sc.pw.flush();
    }

    private static int bfs() {
        ArrayDeque<PII> q = new ArrayDeque<>();

        for (int[] r : d) {
            Arrays.fill(r, -1);
        }

        d[0][0] = 0;

        q.addLast(new PII(0, 0));

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            PII t = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                    d[x][y] = d[t.x][t.y] + 1;
                    q.addLast(new PII(x, y));
                }
            }
        }
        return d[n - 1][m - 1];
    }

    public static class PII {

        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
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
