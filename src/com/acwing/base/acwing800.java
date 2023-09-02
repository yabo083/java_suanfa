package com.acwing.base;

import java.io.*;

public class acwing800 {

    static int N = 100010;

    static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0, j = m - 1; i < n; i++) {
            while (a[i] + b[j] > x) {
                j--;
            }
            if (a[i] + b[j] == x){
                sc.write(i + " " + j);
                return;
            }
        }

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
