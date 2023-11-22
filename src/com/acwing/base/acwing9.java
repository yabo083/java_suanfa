package com.acwing.base;

import java.io.*;

public class acwing9 {

    public static int N = 110;

    public static int n, m;
    public static int[][] v = new int[N][N], w = new int[N][N];
    public static int[] s = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 0; j < s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) { // 循环物品组
            for (int j = m; j >= 0; j--) { // 循环可用体积，体积逆序循环，是为了实现新旧值的滚动数组，实现了可以优化成一维。
                for (int k = 0; k < s[i]; k++) { // 循环该选哪个，也就是决策
                    if (v[i][k] <= j) {
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]); // 实在不会，就模拟模拟。
                    }
                }
            }
        }

        sc.write(f[m]);
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
