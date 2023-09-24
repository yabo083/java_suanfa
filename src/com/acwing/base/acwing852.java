package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class acwing852 {

    public static int N = 2010, M = 10010;

    public static int n, m, idx;

    public static int[] h = new int[N], w = new int[M], e = new int[M], ne = new int[M];

    public static int[] dist = new int[N], cnt = new int[N];

    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
        }

        if (spfa()) {
            sc.write("Yes");
        } else {
            sc.write("No");
        }
        sc.pw.flush();

    }

    private static boolean spfa() {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            st[i] = true;
            q.addLast(i);
        }

        while (!q.isEmpty()) {
            int t = q.removeFirst();

            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]){
                        q.addLast(j);
                        st[j] = true;
                    }
                }

            }
        }
        return false;

    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
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
