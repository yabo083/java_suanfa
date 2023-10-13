package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing887 {

    public static int p;

    public static void main(String[] args) throws IOException {
        int n = scpro.nextInt();
        while (n-- > 0) {
            long a = scpro.nextLong(), b = scpro.nextLong();
            p = scpro.nextInt();
            a = a + b;
            scpro.write(lucas(a, b) + "\n");
        }
        scpro.pw.flush();
    }

    private static long lucas(long a, long b) {
        if (a < p && b < p) {
            return C(a, b);
        }
        return C(a % p, b % p) * lucas(a / p, b / p) % p;
    }

    private static long C(long a, long b) {
        if (b > a) {
            return 0;
        }
        if (b > a - b) {
            b = a - b;
        }
        long n = 1, d = 1;
        for (int i = 0; i < b; i++) {
            n = n * (a - i) % p;
            d = d * (i + 1) % p;
        }
        return n * qmi(d, p - 2) % p;

    }

    private static long qmi(long a, int k) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * a % p;
            }
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }

    public static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer，相比于readline读一行，这个方法可以读混合字符串和数字的一行而且只读取字符串。
        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数
        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.print(o);
        }

    }

}
