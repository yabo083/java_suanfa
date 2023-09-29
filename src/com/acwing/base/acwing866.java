package com.acwing.base;

import java.io.*;

public class acwing866 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        while (n-- > 0) {
            int x = sc.nextInt();
            if (is_prime(x)) {
                sc.write("Yes\n");
            } else {
                sc.write("No\n");
            }
        }

        sc.pw.flush();
    }

    private static boolean is_prime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;

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
