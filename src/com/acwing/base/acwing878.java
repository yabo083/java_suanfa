package com.acwing.base;

import java.io.*;

public class acwing878 {

    public static int[] x1 = {0}, y1 = {0};


    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
            x1[0] = 0;
            y1[0] = 0;
            int d = exgcd(a, m, x1, y1);
            if (b % d == 0) {
                sc.write((long) b / d * x1[0] % m + "\n");
            } else {
                sc.write("impossible\n");
            }
        }
        sc.pw.flush();
    }

    private static int exgcd(int a, int b, int[] x1, int[] y1) {
        if (b == 0) {
            x1[0] = 1;
            y1[0] = 0;
            return a;
        }
        int d = exgcd(b, a % b, y1, x1);
        y1[0] -= a / b * x1[0];
        return d;
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
