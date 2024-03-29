package com.acwing.base;

import java.io.*;

public class acwing891 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        while(n-- > 0){
            long res = 0;
            int m = sc.nextInt();
            while (m-- > 0) {
                int x = sc.nextInt();
                res ^= x;
            }
            if (res != 0) {
                sc.write("Yes\n");
            } else {
                sc.write("No\n");
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
