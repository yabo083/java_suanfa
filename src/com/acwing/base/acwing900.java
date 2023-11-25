package com.acwing.base;

import java.io.*;

public class acwing900 {

    public static int N = 1010, mod = (int) (1e9 + 7);

    public static int n;

    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();

        f[0] = 1;

        for (int i = 1; i <= n; i++) { // represent item，object，here are the available numbers
            for (int j = i; j <= n; j++) { // represent bulk，here is the value of the number，MARK！
                f[j] = (f[j] + f[j - i]) % mod;
            }
        }

        sc.write(f[n]);
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
