package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing897 {

    public static int N = 1010;

    public static int n, m;

    public static char[] a = new char[N], b = new char[N];

    public static int[][] f = new int[N][N];

    public static void LCS() throws IOException {
        n = scpro.nextInt();
        m = scpro.nextInt();
        // 将字符串从1开始读入，这样就不用考虑边界问题了————这个技巧只有在对时间要求不高的时候才能用，因为这步是很慢的，所以就不用了。
        a = (scpro.readLine()).toCharArray();
        b = (scpro.readLine()).toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        scpro.write(f[n][m] + "\n");
    }

    public static void getLCS() {
        int i = n, j = m, k = f[n][m];
        char[] res = new char[k--];
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                res[k--] = a[i - 1];
                i--;
                j--;
            } else if (f[i - 1][j] > f[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        for (char re : res) {
            scpro.write(re);
        }
    }

    public static void main(String[] args) throws IOException {
        LCS();
        getLCS();// 方法越是调用，就越是慢，只有写在主线程里的代码才是最快的
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
