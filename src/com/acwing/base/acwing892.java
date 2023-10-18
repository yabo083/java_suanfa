package com.acwing.base;

import java.io.*;

public class acwing892 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if ((i & 1) == 1) {
                res ^= x;
            }
        }
        if (res != 0) {
            sc.write("Yes\n");
        } else {
            sc.write("No\n");
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
