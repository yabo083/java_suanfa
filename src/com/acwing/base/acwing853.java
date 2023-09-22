package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing853 {

    public static int N = 510, M = 10010;
    public static Edge[] edges = new Edge[M];
    public static int n, m, k;
    public static int[] dist = new int[N];
    public static int[] last = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        bellman_ford();

        if (dist[n] > 0x3f3f3f3f / 2) {
            sc.write("impossible");
        } else {
            sc.write(dist[n]);
        }

        sc.pw.flush();
    }

    private static void bellman_ford() {
        Arrays.fill(dist, 0x3f3f3f3f);

        dist[1] = 0;

        for (int i = 0; i < k; i++) {
            last = Arrays.copyOf(dist, n + 1);
            for (int j = 0; j < m; j++) {
                Edge e = edges[j];
                dist[e.b] = Math.min(dist[e.b], last[e.a] + e.c);
            }
        }
    }

    public static class Edge {

        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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
