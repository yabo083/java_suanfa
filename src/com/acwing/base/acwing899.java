package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing899 {

    public static int N = 1010;

    public static char[][] str = new char[N][N];
    public static int[] f = new int[N];

    public static int n, m;

    public static void main(String[] args) throws IOException {
        n = scpro.nextInt();
        m = scpro.nextInt();
        for (int i = 0; i < n; i++) {
            str[i] = scpro.readLine().toCharArray();
        }

        while (m-- > 0) {
            char[] consultation = scpro.next().toCharArray();
            int limit = scpro.nextInt();

            int res = 0;
            for (int i = 0; i < n; i++) {
                if (edit_distance(str[i], consultation) <= limit) {
                    res++;
                }
            }

            scpro.write(res+"\n");
        }
        scpro.pw.flush();
    }

    private static int edit_distance(char[] chars, char[] consultation) {
        int la = chars.length, lb = consultation.length;

        for (int i = 0; i <= lb; i++) {
            f[i] = i;
        }

        for (int i = 1; i <= la; i++) {
            int t1 = f[0]++;
            for (int j = 1; j <= lb; j++) {
                int t2 = f[j];
                if (chars[i - 1] == consultation[j - 1]) {
                    f[j] = t1;
                } else {
                    f[j] = Math.min(t1, Math.min(f[j - 1], f[j])) + 1;
                }
                t1 = t2;
            }
        }

        return f[lb];

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
