package com.acwing.base;

import java.io.*;
import java.util.HashMap;

public class acwing870 {

    public static int M = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        HashMap<Integer, Integer> primes = new HashMap<>();

        while (n-- > 0) {
            int x = sc.nextInt();

            for (int i = 2; i <= x / i; i++) {
                while (x % i == 0) {
                    x /= i;
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                }
            }

            if (x > 1) {
                primes.put(x, primes.getOrDefault(x, 0) + 1);
            }
        }

        Long res = 1L;
        for (Integer p : primes.values()) {
            res = res * (p + 1) % M;
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
