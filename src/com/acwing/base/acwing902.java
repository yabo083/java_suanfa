package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing902 {

    public static int N = 1010;

    public static int n, m;

    public static char[] a = new char[N], b = new char[N];

    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        n = scpro.nextInt();
        a = (scpro.readLine()).toCharArray();
        m = scpro.nextInt();
        b = (scpro.readLine()).toCharArray();

        for (int i = 0; i <= m; i++) {
            f[i] = i; // 字符串b有m个字符，对应表格模型有m列，所以这么初始化（其实多赋了一行
        }
        for (int i = 1; i <= n; i++) {
            int t1 = f[0]++; // 这里为什么不可以写成t1 = i呢？
            for (int j = 1; j <= m; j++) {
                int t2 = f[j];
                if (a[i - 1] == b[j - 1]) {
                    f[j] = t1;
                } else {
                    f[j] = Math.min(t1, Math.min(f[j - 1], f[j])) + 1;
                }
                t1 = t2;
            }
        }

        scpro.write(f[m]);
        scpro.pw.flush();

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
            pw.print(o);
        }

    }

}
