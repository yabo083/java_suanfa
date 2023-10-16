package com.acwing.base;

import java.io.*;

public class acwing890 {

    public static int N = 20;

    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 1; i < (1 << m); i++) {
            long t = 1, s = -1;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    t *= p[j];
                    s = -s;
                    if (t > n) {
                        t = 0;
                        break;
                    }
                }
            }

            if (t != 0) {
                res += s * (n / t);
            }
        }

        sc.write(res);
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
