package com.acwing.base;

import java.io.*;

public class acwing877 {

    public static int x, y;
    public static int[] x1 = {0}, y1 = {0};
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            x = y = 0;
            exgcd(a, b);
//            exgcd(a, b, x1, y1);
            sc.write(x + " " + y + "\n");
//            sc.write(x1[0] + " " + y1[0] + "\n");
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


    // 采用全局变量和无需返回值的方法。
    private static void exgcd(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        exgcd(b, a % b);
        int t = x;
        x = y;
        y = t - a / b * y;
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
