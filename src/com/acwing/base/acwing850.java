package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class acwing850 {

    public static int N = (int) (1e6 + 10);
    public static int n, m, idx;
    public static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
        }

        sc.write(dijkstra());
        sc.pw.flush();
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;

    }

    private static int dijkstra() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<pair> heap = new PriorityQueue<>((a, b) -> a.x - b.x);

        heap.add(new pair(0, 1));

        while (!heap.isEmpty()) {
            pair t = heap.poll();
            int y = t.y;
            if (st[y]) {
                continue;
            }
            st[y] = true;

            for (int i = h[y]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[y] + w[i]) {
                    dist[j] = dist[y] + w[i];
                    heap.add(new pair(dist[j], j));
                }
            }
        }

        if (dist[n] == 0x3f3f3f3f) {
            return -1;
        }
        return dist[n];
    }

    public static class pair {

        int x, y;

        public pair(int x, int y) {
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
