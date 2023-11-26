package com.competition.jitiao;

import java.io.*;

public class gupiao {

    public static int N = 100010;

    public static int n;
    public static int[] a = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int len = 0, res = 0;
        q[0] = (int) (-10e9 - 10); // 因为下面用if把逻辑剥离了出来，所以为了第一个数可以正确落到序列中，需要设为最小值
        for (int i = 0; i < n; i++) {
            if (a[i] > q[len]) {
                q[++len] = a[i];
            } else {
                res = Math.max(res, len);
                len = 0;
                q = new int[N];
                q[len] = a[i];
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


