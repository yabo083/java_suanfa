package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing859 {

    public static int N = 100010, M = 200010, INF = 0x3f3f3f3f;

    public static int n, m;

    public static int[] p = new int[N];

    public static Edge[] edges = new Edge[M];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int t = kruskal();

        if (t == INF) {
            sc.write("impossible");
        } else {
            sc.write(t);
        }

        sc.pw.flush();
    }

    private static int kruskal() {
        Arrays.sort(edges, 0, m, (o1, o2) -> o1.w - o2.w);

        for (int i = 1; i <= n; i++) {
            p[i] = i;

        }

        int res = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;

            a = find(a);
            b = find(b);

            if (a != b) {
                p[a] = b;
                res += w;
                cnt++;
            }
        }

        if (cnt < n - 1) {
            return INF;
        }
        return res;


    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static class Edge {

        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
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
