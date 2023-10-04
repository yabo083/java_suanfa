package com.acwing.base;

import java.io.*;

public class acwing875 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt();
            sc.write(qmi(a, b, p) + "\n");
        }
        sc.pw.flush();
    }

    private static long qmi(int a, int b, int p) {
        long res = 1 % p;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % p;
            }
            a = (int) ((long)a * a % p);
            b >>= 1;
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
