package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing861 {

    public static int N = 510, M = 100010;

    public static int n1, n2, m, idx;

    public static int[] h = new int[N], e = new int[M], ne = new int[M];

    public static int[] match = new int[N];

    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(a, b);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) {
                res++;
            }
        }
        sc.write(res);
        sc.pw.flush();
    }

    private static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static void add(int a, int b) {
        e[idx] = b;
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
