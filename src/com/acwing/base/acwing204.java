package com.acwing.base;

import java.io.*;

public class acwing204 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        long a1 = sc.nextInt(), m1 = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            long a2 = sc.nextInt(), m2 = sc.nextInt();
            long[] k1 = {0}, k2 = {0};
            long d = exgcd(a1, a2, k1, k2);
            if ((m2 - m1) % d != 0) {
                sc.write(-1 + "\n");
                sc.pw.flush();
                return;
            }
            k1[0] = k1[0] * (m2 - m1) / d % (a2 / d); // 为什么这里要对a2/d取模？因为不模会溢出，也是为了输出最小非负整数解（这是数学性质）
            m1 += k1[0] * a1;
            a1 *= (long) ((double) a2 / d);
        }
        sc.write((m1 % a1 + a1) % a1 + "\n"); // 为什么这里要这么写？是为了输出最小非负整数解
        sc.pw.flush();

        int a = -5, b = 2;
        System.out.println(a % b);
        System.out.println((a + b) % b);
        System.out.println((a % b + b) % b);
        System.out.println(Math.floorMod(a, b));
        System.out.println(a % b + b);

    }

    private static long exgcd(long a, long b, long[] x1, long[] y1) {
        if (b == 0) {
            x1[0] = 1;
            y1[0] = 0;
            return a;
        }
        long d = exgcd(b, a % b, y1, x1);
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
