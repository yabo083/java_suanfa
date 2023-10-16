package com.acwing.base;

import java.io.*;

public class acwing890_2 {

    public static int N = 20;
    public static int n, m, res;
    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }

        dfs(0,1,-1);
        sc.write(res);
        sc.pw.flush();
    }

    private static void dfs(int i, int t, int op) {
        if (i == m){
            if (t != 1){
                res += op * (n / t);
            }
            return;
        }

        dfs(i +1, t, op);
        if (t <= n / p[i])
            dfs(i + 1, t * p[i], -op);
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
