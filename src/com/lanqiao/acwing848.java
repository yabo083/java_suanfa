package com.lanqiao;

import java.io.*;
import java.util.Arrays;

public class acwing848 {

    static int N = 100010;

    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], q = new int[N];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topsort() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
                q[++tt] = i;

        while (hh <= tt) {
            if (tt == n - 1) break;
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0)
                    q[++tt] = j;
            }

        }

        return tt == n - 1;
    }

    static class sc {
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

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            d[b] ++;
        }

        if (!topsort()){
            sc.write("-1");
        }else {
            for (int i = 0; i < n; i ++)
                sc.write(q[i] + " ");
        }
        sc.pw.flush();
    }


}
