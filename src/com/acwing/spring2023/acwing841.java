package com.acwing.spring2023;

import java.io.*;
import java.util.StringTokenizer;

public class acwing841 {

    static int N = 100010, P = 131;

    static int n, m;
    static char[] str = new char[N];
    static long[] h = new long[N], p = new long[N];

    static long get(int l, int r){
        return h[r] - h[l - 1] * p[r - l + 1]; //主要公式，神似用前缀和求区间和，但不同的是，为了使数位对齐，需要乘上p[r - l + 1]；
    }                                          //忘了就去在看看视频就行，配合评论。

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        str = sc.readLine().toCharArray();

        p[0] = 1;
        for (int i = 1; i <= n; i ++){
            h[i] = h[i - 1] * P + str[i - 1]; //算出前i位字符串对应P进制下数的前缀和，左为高位，右为低位
            p[i] = p[i - 1] * P;              //预处理下p的各种次方，待会根据下标取用
        }

        while (m -- > 0){
            int l1 = sc.nextInt(), r1 = sc.nextInt(), l2 = sc.nextInt(), r2 = sc.nextInt();
            if (get(l1, r1) == get(l2, r2)) sc.write("Yes");
            else sc.write("No");
        }
        sc.pw.flush();

    }

    static class sc {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        sc() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer
        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数
        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
        }


    }


}
