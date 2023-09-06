package com.acwing.base;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class acwing828 {

    public static int N = 100010;

    public static int[] stk = new int[N];

    public static int tt = 0;

    public static void main(String[] args) {
        int m = scpro.nextInt();

        while (m-- > 0) {
            String op = scpro.next();
            if (op.equals("push")) {
                int x = scpro.nextInt();
                stk[++tt] = x;
            } else if (op.equals("pop")) {
                tt--;
            } else if (op.equals("empty")) {
                scpro.write((tt == 0 ? "YES" : "NO") + "\n");
            } else if (op.equals("query")) {
                scpro.write(stk[tt]);
            }
        }
        scpro.pw.flush();

    }

    static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
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

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }

}
