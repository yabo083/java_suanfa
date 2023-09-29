package com.acwing.base;

import java.io.*;

public class acwing867 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            divide(x);
        }
        sc.pw.flush();
    }

    private static void divide(int x) {
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                int s = 0;
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                sc.write(i + " " + s + "\n");
            }
        }
        if (x > 1) {
            sc.write(x + " 1\n");
        }
        sc.write("\n");
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
