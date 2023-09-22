package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acwing840 {

    public static int N = 200003, NULL = 0x3f3f3f3f;

    public static int[] h = new int[N];

    public static void main(String[] args) {
        Arrays.fill(h, NULL);
        int n = scpro.nextInt();

        while (n-- > 0) {
            String op = scpro.next();
            int x = scpro.nextInt();
            if ("I".equals(op)) {
                h[find(x)] = x;
            } else {
                if (h[find(x)] == NULL) {
                    scpro.write("No\n");
                } else {
                    scpro.write("Yes\n");
                }
            }
        }
        scpro.pw.flush();
    }

    private static int find(int x) {
        int t = (x % N + N) % N;
        while (h[t] != NULL && h[t] != x) {
            t++;
            if (t == N) {
                t = 0;
            }
        }
        return t;
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
        }

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }
}
