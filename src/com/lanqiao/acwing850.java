package com.lanqiao;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class acwing850 {

    static final int N = 1000010;

    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N], dist = new int[N];
    static boolean[] st = new boolean[N];

    static class PII {
        int first, second;

        public PII(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }

    static int dijkstra() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<PII> heap = new PriorityQueue<>((a, b) -> b.first - a.first);
        heap.add(new PII(0, 1));

        while (!heap.isEmpty()) {
            PII t = heap.poll();
            int ver = t.second, distance = t.first;

            if (st[ver]) continue;

            st[ver] = true;

            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];

                if (dist[j] > distance + w[i])
                {
                    dist[j] = distance + w[i];
                    heap.add(new PII(dist[i], j));
                }
            }
        }

        if (dist[n] == 0x3f3f3f3f) return -1;

        return dist[n];

    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a,b,c);
        }

        sc.write(dijkstra());
    }


}
