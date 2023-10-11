package com.acwing.base;

import java.io.*;

public class acwing884 {

    public static int N = 110;

    public static int n;

    public static int[][] a = new int[N][N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int t = gauss();

        if (t == 0) {
            for (int i = 0; i < n; i++) {
                sc.write(a[i][n] + "\n");
            }
        } else if (t == 1) {
            sc.write("Multiple sets of solutions");
        } else {
            sc.write("No solution");
        }
        sc.pw.flush();

    }

    private static int gauss() {
        int c, r;
        for (c = r = 0; c < n; c++) {
            int t = r;
            for (int i = r; i < n; i++) {
                if (a[i][c] != 0) {
                    t = i;
                }
            }

            if (a[t][c] == 0) {
                continue;
            }
            for (int i = c; i <= n; i++) {
                int tmp = a[t][i];
                a[t][i] = a[r][i];
                a[r][i] = tmp;
            }

            for (int i = r + 1; i < n; i++) {
                if (a[i][c] != 0) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] ^= a[r][j];
                    }
                }
            }

            r++;
        }

        if (r < n) {
            for (int i = r; i < n; i++) {
                if (a[i][n] != 0) {
                    return 2;
                }
            }
            return 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                a[i][n] ^= a[i][j] * a[j][n];
            }
        }

        return 0;

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
