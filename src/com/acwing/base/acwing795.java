package com.acwing.base;

import java.io.*;

public class acwing795 {

    static int N = 100010;

    static long[] a = new long[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        //边输入边计算
        for (int i = 1; i <= n; i ++) {
            a[i] = a[i - 1] + sc.nextInt();
        }
        while (m -- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            sc.write(a[r] - a[l - 1]);
        }

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