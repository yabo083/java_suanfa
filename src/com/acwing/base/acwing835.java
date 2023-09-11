package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing835 {

    public static int N = 100010;

    public static int[][] son = new int[N][26];

    public static int[] cnt = new int[N];

    public static int idx = 0;

    public static char[] strarr = new char[N];

    public static void main(String[] args) {
        int n = scpro.nextInt();

        while (n-- > 0) {
            String op = scpro.next();
            String str = scpro.next();
            strarr = str.toCharArray();
            if (op.equals("I")) {
                insert(strarr);
            } else {
                scpro.write(query(strarr) + "\n");
            }
        }

        scpro.pw.flush();
    }

    private static int query(char[] str) {
        int p = 0;
        for (char c : str) {
            int u = c - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }

    private static void insert(char[] str) {
        int p = 0;
        for (char c : str) {
            int u = c - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    public static class scpro {

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
            pw.print(o);
        }

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }

}
