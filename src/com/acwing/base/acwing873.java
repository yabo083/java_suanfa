package com.acwing.base;

import java.io.*;

public class acwing873 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            sc.write(phi(x));
        }
        sc.pw.flush();
    }

    private static int phi(int x) {
        int res = x;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                res = res / i * (i - 1);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) {
            res = res / x * (x - 1);
        }
        return res;
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
