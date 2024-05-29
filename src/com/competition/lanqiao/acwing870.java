package com.competition.lanqiao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class acwing870 {

    static int N = 110, mod = (int) (1000000007);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        Map<Integer, Integer> primes = new HashMap<>();
        while (n-- > 0) {
            int x = sc.nextInt();
            for (int i = 2; i <= x / i; i++)
                while (x % i == 0) {
                    x /= i;
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                }
            if (x > 1)
                primes.put(x, primes.getOrDefault(x, 0) + 1);
        }

        long res = 1;
        for (Integer p : primes.values())
            res = (res * (p + 1)) % mod;

        sc.write(res);

    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }


}
