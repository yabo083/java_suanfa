package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing831 {

    public static int N = 100010, M = 1000010;

    public static int[] ne = new int[N];

    public static char[] s = new char[M], p = new char[N];

    public static void main(String[] args) throws IOException {
        int n = scpro.nextInt();
        String s1 = scpro.readLine();
        int m = scpro.nextInt();
        String s2 = scpro.readLine();
        System.arraycopy(s1.toCharArray(), 0, p, 1, n);
        System.arraycopy(s2.toCharArray(), 0, s, 1, m);

        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) {
                j = ne[j];
            }
            if (s[i] == p[j + 1]) {
                j++;
            }
            if (j == n) {
                scpro.write((i - n) + " ");
                j = ne[j];
            }
        }

        scpro.pw.flush();


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
