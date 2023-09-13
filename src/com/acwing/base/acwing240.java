package com.acwing.base;

import java.io.*;

public class acwing240 {

    public static int N = 50010;

    public static int[] p = new int[N], d = new int[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0;
        while (m-- > 0) {
            int t = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            if (x > n || y > n) {
                res++;
            } else {
                int px = find(x), py = find(y);
                if (t == 1) {
                    if (px == py && (d[x] - d[y]) % 3 != 0) {
                        res++;
                    } else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                } else {
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) {
                        res++;
                    } else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] + 1 - d[x];
                    }
                }
            }
        }
        sc.write(res);
        sc.pw.flush();
    }

    private static int find(int x) {
        if (p[x] != x) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
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
