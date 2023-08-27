package com.acwing.spring2023;

import java.io.*;

public class acwing3473 {

    static int n;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            if (a % 2 != 0) {
                sc.write("0 0\n");
            } else if (a % 4 == 0) {
                sc.write(a / 4 + " " + a / 2 + "\n");
            } else {
                sc.write(a / 4 + 1 + " " + a / 2 + "\n");
            }
        }
        sc.pw.flush();
    }

    static class sc {

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
