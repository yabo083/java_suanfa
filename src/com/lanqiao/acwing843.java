package com.lanqiao;

import java.io.*;

/**
 * 只用一个列数组，完成操作
 */
public class acwing843 {

    static int N = 20, n;

    static char[][] g = new char[N][N];

    static boolean[] col = new boolean[N], dg = new boolean[N], udg = new boolean[N];

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
        }

    }

    /**
     * @param u 代表每一行
     */
    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                    sc.write(String.valueOf(g[i]));
            }
            sc.write("");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[u - i + n]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[u - i + n] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[u - i + n] = false;
                g[u][i] = '.';
            }
        }

    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                g[i][j] = '.';
        dfs(0);
        sc.pw.flush();
    }
}
