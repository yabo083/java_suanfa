package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing836 {

    public static int N = 100010;

    public static int[] p = new int[N];

    public static void main(String[] args) {
        int n = scpro.nextInt();
        int m = scpro.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        while (m-- > 0) {
            String op = scpro.next();
            int a = scpro.nextInt();
            int b = scpro.nextInt();
            if ("M".equals(op)) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    scpro.write("Yes");
                } else {
                    scpro.write("No");
                }
            }

        }
    }

    private static int find(int x) {
        return p[x] != x ? p[x] = find(p[x]) : p[x];
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
