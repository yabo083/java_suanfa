package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing846 {

    public static int N = 100010;

    public static boolean[] st = new boolean[N];

    public static int[] h = new int[N], e = new int[N * 2], ne = new int[N * 2];

    public static int idx, n, ans = N;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        sc.write(ans);
        sc.pw.flush();


    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int dfs(int u) {
        st[u] = true;

        int size = 0, sum = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (st[j]) {
                continue;
            }

            int s = dfs(j);

            size = Math.max(size, s);
            sum += s;
        }

        size = Math.max(size, n - sum);
        ans = Math.min(ans, size);

        return sum;
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
