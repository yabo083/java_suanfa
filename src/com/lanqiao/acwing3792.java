package com.lanqiao;

import java.io.*;

public class acwing3792 {

    static int N = 1010,cnt,T,n,m;

    static int[] primes = new int[N], sum = new int[N];
    static boolean[] st = new boolean[N];

    //线性筛法，当模板背就行
    static void get_primes(int n){
        for (int i = 2; i<= n; i++){
            if (!st[i]) primes[cnt ++] = i;
            for (int j = 0; primes[j] <= n / i ; j ++){
                st[primes[j] * i] = true;
                if (i % primes[j] == 0 ) break;
            }
        }
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
        public static  <T> void write(T o) {
            pw.println(o);
        }


    }

    public static void main(String[] args) throws IOException {
        T = sc.nextInt();

        //先求一下，N之前的所有质数，减1是为了防止st[i]越界，至于primes[]不用担心，因为它永远存不满
        get_primes(N - 1);

        //这里是自己先求好满足条件且在N范围内的“特殊质数”有多少，相信可以看懂
        for (int i = 1; i < cnt; i ++){
            int s = primes[i] + primes[i -1] + 1;
            if (s < N && !st[s])
                sum[s] = 1;
        }

        //这下求个前缀和就方便多了，你要n之前的特殊质数，直接返回sum[n]就好了。
        for (int i = 1; i < N; i ++)
            sum[i] += sum[i - 1];

        while (T -- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (sum[n] >= k) sc.write("YES");
            else sc.write("NO");
        }
        sc.pw.flush();
    }


}
