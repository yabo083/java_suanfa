package com.acwing.base;

import java.io.*;

public class acwing868 {


    public static int N = 1000010;

    public static int[] primes = new int[N];//存质数

    public static int cnt;//质数个数

    public static boolean[] st = new boolean[N];//false表示未被筛掉，true表示已被筛掉


    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        get_prime3(n);
        sc.write(cnt);
        sc.pw.flush();
    }

    //朴素筛法
    private static void get_prime1(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = i + i; j <= n; i++) {
                st[j] = true;
            }
        }
    }

    //埃式筛法
    private static void get_prime2(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                for (int j = i * i; j <= n; j += i) {
                    st[j] = true;
                }
            }
        }
    }

    //线性筛法
    private static void get_prime3(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
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
