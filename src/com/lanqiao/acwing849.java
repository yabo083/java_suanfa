package com.lanqiao;

import java.io.*;
import java.util.Arrays;

public class acwing849 {

    static int N = 510;

    static int n ,m;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];

    static boolean[] st = new boolean[N];

    static int dijkstra(){
        Arrays.fill(dist, 0x3f3f3f3f);

        dist[1] = 0;

        for (int i = 0; i < n - 1; i ++){
            int t = - 1;
            for (int j = 1; j <= n; j ++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            for (int j = 1; j <= n; j ++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);

            st[t] = true;
        }

        if (dist[n] == 0x3f) return -1;
        return dist[n];
    }

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

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int[] row : g) Arrays.fill(row, 0x3f3f3f3f);

        while (m -- > 0){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        sc.write(dijkstra());
    }

}
