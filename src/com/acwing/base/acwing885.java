package com.acwing.base;

import java.io.*;

public class acwing885 {

    public static int N = 2010, mod = (int) (1e9 + 7);

    public static int[][] c = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        init();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();

            sc.write(c[a][b] + "\n");
        }
        sc.pw.flush();
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
                }
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
