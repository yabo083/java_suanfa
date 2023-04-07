package com.lanqiao;

import java.io.*;

public class acwing854 {

    static int N = 210, INF = 1000000000;

    static int n, m, Q;

    static int[][] d = new int[N][N];

    static void floyd(){
        for (int k = 1; k <= n; k ++)
            for (int i = 1; i <= n; i ++)
                for (int j = 1; j <= n; j ++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

    }


    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }
    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        Q = sc.nextInt();

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j ++)
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            d[a][b] = Math.min(d[a][b], c);
        }

        floyd();

        while (Q -- > 0 ){
            int a = sc.nextInt() ,b = sc.nextInt();

            int t = d[a][b];
            if (t > INF / 2) sc.write("impossible");
            else sc.write(t);
        }
    }
}
