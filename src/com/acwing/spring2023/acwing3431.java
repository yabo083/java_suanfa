package com.acwing.spring2023;

import java.io.*;
import java.util.StringTokenizer;

public class acwing3431 {


    public static void main(String[] args) throws IOException {
        String str;
        while ((str = sc.readLine()) != null) {
            int res = 0, p = 1;
            for (int i = str.length() - 1; i >= 0; i--, p = p * 2 + 1) {
                res += (str.charAt(i) - '0') * p;
            }
            sc.write(res);
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
