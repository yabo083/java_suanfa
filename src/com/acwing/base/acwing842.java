package com.acwing.base;

import java.io.*;

public class acwing842 {

    public static int N = 10;
    public static int[] path = new int[N];

    public static int n = 0;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();

        dfs(0, 0);
        sc.pw.flush();
    }

    private static void dfs(int u, int state) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                sc.write(path[i] + " ");
            }
            sc.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((state >> i & 1) != 1) {
                path[u] = i + 1;
                dfs(u + 1, state + (1 << i));
            }
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
