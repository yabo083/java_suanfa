package com.acwing.base;

import java.io.*;


public class acwing797 {

    public static int N = 100010;

    public static int[] b = new int[N];

    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
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

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            insert(i, i, sc.nextInt());
        }

        for (int j = 1; j <= m; j++) {
            int l = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
            insert(l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            sc.write(b[i]);
        }
        sc.pw.flush();
    }


}
