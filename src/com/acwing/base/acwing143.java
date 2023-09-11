package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing143 {

    public static int N = 100010, M = 3100010;

    public static int[] a = new int[N];

    public static int[][] son = new int[M][2];

    public static int idx = 0;

    public static void main(String[] args) throws IOException {
        int n = scpro.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scpro.nextInt();
            insert(a[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, query(a[i]));
        }

        scpro.write(res);
        scpro.pw.flush();
    }

    private static int query(int x) {
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int s = 1 - ((x >> i) & 1);
            if (son[p][s] != 0) {
                res += (1 << i);
                p = son[p][s];
            } else {
                p = son[p][1 - s];
            }
        }
        return res;
    }

    private static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            if (son[p][x >> i & 1] == 0) {
                son[p][x >> i & 1] = ++idx;
            }
            p = son[p][x >> i & 1];
        }
    }

    public static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer，相比于readline读一行，这个方法可以读混合字符串和数字的一行而且只读取字符串。
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
            pw.flush();
        }

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }



    }

}
