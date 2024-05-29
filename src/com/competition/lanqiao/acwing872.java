package com.competition.lanqiao;

import java.io.*;

public class acwing872 {

    static int n, a, b;

    public static int gcd1(int a, int b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    //Stein算法（结合辗转相除法和更相减损法的优势以及移位运算）求最大公约数
    public static int gcd2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a % 2 == 0 && b % 2 == 0) return 2 * gcd2(a >> 1, b >> 1);
        else if (a % 2 == 0) return gcd2(a >> 1, b);
        else if (b % 2 == 0) return gcd2(a, b >> 1);
        else return gcd2(Math.abs(a - b), Math.min(a, b));
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
        }


    }

    public static void main(String[] args) throws IOException {

        n = sc.nextInt();
        while (n-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            sc.write(gcd2(a, b) + " ");
        }

    }
}
