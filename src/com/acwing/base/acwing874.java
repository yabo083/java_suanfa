package com.acwing.base;

import java.io.*;

public class acwing874 {

    public static int N = 1000010;

    public static int[] primes = new int[N], euler = new int[N];

    public static boolean[] st = new boolean[N];

    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        get_eulers(n);

        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += euler[i];
        }

        sc.write(res);
        sc.pw.flush();
    }

    private static void get_eulers(int n) {
        euler[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                euler[i] = i - 1;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                int t = primes[j] * i;
                st[t] = true;
                if (i % primes[j] == 0) {
                    euler[t] = euler[i] * primes[j];
                    break;
                }
                euler[t] = euler[i] * (primes[j] - 1);
            }
        }
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
