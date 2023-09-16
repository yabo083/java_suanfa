package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing841 {

    public static int N = 100010, P = 131;

    public static char[] str = new char[N];

    public static long[] h = new long[N], p = new long[N];

    public static void main(String[] args) throws IOException {
        int n = scpro.nextInt(), m = scpro.nextInt();
        // scpro.readLine().getChars(0, n, str, 1); 方法1

        // String line = scpro.readLine();
        // char[] str = Arrays.copyOf(line.toCharArray(), N); 方法2

        // str = scpro.readLine().toCharArray(); 方法3的输入

        str = (" "+scpro.readLine()).toCharArray(); // 这么赋，方法4

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + str[i]; // 方法3, 照常输入给str就行。
            p[i] = p[i - 1] * P;
        }

        while (m-- > 0) {
            int l1 = scpro.nextInt(), r1 = scpro.nextInt(), l2 = scpro.nextInt(), r2 = scpro.nextInt();
            if (get(l1, r1) == get(l2, r2)) {
                scpro.write("Yes\n");
            } else {
                scpro.write("No\n");
            }
        }
        scpro.pw.flush();
    }

    private static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
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
