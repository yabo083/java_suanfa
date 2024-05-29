package com.competition.lanqiao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class acwing871 {

    static int N = 110, mod = (int) (1000000007);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        Map<Integer, Integer> primes = new HashMap<>();
        while (n-- > 0) {
            int x = acwing870.sc.nextInt();
            for (int i = 2; i <= x / i; i++)
                while (x % i == 0) {
                    x /= i;
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                }
            if (x > 1) primes.put(x, primes.getOrDefault(x, 0) + 1);
        }

        long res = 1;
        //写一个与下面for循环功能相同的代码
        for (Integer a : primes.keySet()) {
            long sum = 0;
            int k = primes.get(a);

//          long car = 1;
//          while(k-- > 0) car = (car * a + 1) % mod;  //求出a^k + a^(k-1) + ... + a^0

            for (int i = 0; i <= k; i++) {
                long pow = 1;
                int tmp = i;
                while (tmp-- > 0) pow = pow * a % mod;
                sum = (sum + pow) % mod;
            }
            res = res * sum % mod;
        }


        //
        for (Map.Entry<Integer, Integer> p : primes.entrySet()) {
            long a = p.getKey(), b = p.getValue();
            long t = 1;

            //这是秦九韶算法

            while (b-- > 0) t = (t * a + 1) % mod;
            res = res * t % mod;
        }

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
