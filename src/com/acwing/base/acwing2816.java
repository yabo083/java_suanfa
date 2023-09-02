package com.acwing.base;

import java.io.*;

public class acwing2816 {

    public static int N = (int) (1e5 + 10);

    public static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && a[i] != b[j]) {
                j++;
            }
            if (j == m){
                sc.write("No");return;
            }
            j ++;
        }
        sc.write("Yes");
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
