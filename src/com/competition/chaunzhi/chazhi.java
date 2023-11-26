package com.competition.chaunzhi;

import java.io.*;

public class chazhi {

    public static int n;
    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.min(res, Math.abs(a[i] - a[j]));
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
