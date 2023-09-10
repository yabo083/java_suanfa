package com.acwing.base;

import java.io.*;

public class acwing154 {

    public static int N = 1000010;

    public static int[] a = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int hh = 0, tt = 0;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }

            while (hh < tt && a[q[tt - 1]] >= a[i]) {
                tt--;
            }

            q[tt++] = i;

            if (i >= k - 1) {
                sc.write(a[q[hh]] + " ");
            }
        }
        sc.write("\n");
        hh = 0;
        tt = 0;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }

            while (hh < tt && a[q[tt - 1]] <= a[i]) {
                tt--;
            }
            q[tt++] = i;

            if (i >= k - 1) {
                sc.write(a[q[hh]] + " ");
            }
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
