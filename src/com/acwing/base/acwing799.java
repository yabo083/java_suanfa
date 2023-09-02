package com.acwing.base;


import java.io.*;

public class acwing799 {

    static int N = 100010;
    static int[] a = new int[N], s = new int[N];


    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int res = 0;

        for (int i = 0, j = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s[a[i]]++;

            while (s[a[i]] > 1) {
                s[a[j++]]--;
            }
            res = Math.max(res, i - j + 1);
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

