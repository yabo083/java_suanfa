package com.competition.lanqiao;

import java.io.*;
import java.util.Arrays;

public class acwing853 {

    static int N = 510, M = 10010;

    static class Edge{
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        int a, b, c;

    }

    static Edge[] edges = new Edge[M];

    static int n, m, k;

    static int[] dist = new int[N];
    static int[] last = new int[N];

    static void bellman_ford(){
        Arrays.fill(dist, 0x3f3f3f3f);

        dist[1] = 0;

        for (int i = 0; i < k; i ++){
            last = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j ++){
                Edge e = edges[j];
                dist[e.b] = Math.min(dist[e.b], last[e.a] + e.c);
            }
        }
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
        k = sc.nextInt();

        for (int i = 0; i < m; i ++){
            int a = sc.nextInt(), b = sc.nextInt() ,c = sc.nextInt();
            edges[i] = new Edge(a ,b, c);
        }

        bellman_ford();

        if (dist[n] > 0x3f3f3f3f / 2) sc.write("impossible");
        else sc.write(dist[n]);

    }
}
