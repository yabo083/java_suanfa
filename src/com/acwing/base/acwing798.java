package com.acwing.base;

import java.io.*;

public class acwing798 {

    public static int N = 1010;
    public static int[][] b = new int[N][N];

    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, sc.nextInt());
            }
        }

        int[] v = new int[5];
        while (q-- > 0){
            for (int i = 0; i < v.length; i++)
                v[i] = sc.nextInt();
            insert(v[0], v[1], v[2], v[3], v[4]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = b[i][j] + b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
                sc.write(b[i][j] + " ");
            }
            sc.write("\n");
        }
        sc.pw.flush();



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
