package com.acwing.base;

import java.io.*;

public class acwing838 {

    public static int N = 100010;

    public static int[] h = new int[N];

    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            h[i] = sc.nextInt();
        }

        cnt = n;

        for (int i = n / 2; i >= 0; i--) {
            down(i);
        }

        while (m-- > 0) {
            sc.write(h[1] + " ");
            h[1] = h[cnt--];
            down(1);
        }
        sc.pw.flush();
    }

    private static void down(int u) {
        int t = u;
        if (u * 2 <= cnt && h[u * 2] < h[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= cnt && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        if (u != t) {
//            System.out.println("before:" + h[u] + " "+h[t]);
            h[u] = h[u] ^ h[t];
            h[t] = h[t] ^ h[u];
            h[u] = h[u] ^ h[t];
//            System.out.println("after:" + h[u] + " "+h[t]);
            down(t);
        }
    }

    public static void swap3(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
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
