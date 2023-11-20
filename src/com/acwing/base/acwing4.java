package com.acwing.base;

import java.io.*;

public class acwing4 {

    public static int N = 110;
    public static int n, m;
    public static int[] f = new int[N], g = new int[N], q = new int[N];


    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            g = f.clone();
            int v = sc.nextInt(), w = sc.nextInt(), s = sc.nextInt();
            for (int j = 0; j < v; j++) {
                int h = 0, t = -1;
                for (int k = j; k <= m; k += v) {
                    if (h <= t && q[h] < k - s * v) {
                        h++;
                    }
                    if (h <= t) {
                        f[k] = Math.max(g[k], g[q[h]] + (k - q[h]) / v * w);
                    }
                    while (h <= t && g[k] >= g[q[t]] + (k - q[t]) / v * w) {
                        t--;
                    }
                    q[++t] = k;
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
