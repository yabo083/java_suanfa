package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class acwing883 {

    public static int N = 110;
    public static double[][] a = new double[N][N];
    public static double eps = 1e-8;
    public static int n;

    public static void main(String[] args) {
        n = scpro.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                a[i][j] = scpro.nextDouble();
            }
        }

        int t = gauss();
        if (t == 2) {
            scpro.write("No solution");
        } else if (t == 1) {
            scpro.write("Infinite group solution");
        } else {
            for (int i = 0; i < n; i++) {
                scpro.write(String.format("%.2f\n", a[i][n]));
            }
        }

        scpro.pw.flush();
    }

    private static int gauss() {
        int c, r;
        for (c = 0, r = 0; c < n; c++) {
            int t = r;
            for (int i = r; i < n; i++) {
                if (abs(a[i][c]) > abs(a[t][c])) {
                    t = i;
                }
            }

            if (abs(a[t][c]) < eps) {
                continue;
            }

            for (int i = c; i <= n; i++) {
                double tmp = a[t][i];
                a[t][i] = a[r][i];
                a[r][i] = tmp;
            }
            for (int i = n; i >= c; i--) {
                a[r][i] /= a[r][c];
            }
            for (int i = r + 1; i < n; i++) {
                if (abs(a[i][c]) > eps) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] -= a[r][j] * a[i][c];
                    }
                }
            }

            r++;
        }
        if (r < n) {
            for (int i = r; i < n; i++) {
                if (abs(a[i][n]) > eps) {
                    return 2; // 无解，r < n,说明剩下的系数矩阵为0，但在扫描常数列b时，又发现不为0，这不就矛盾了？
                }
            }
            return 1; // 有无穷多组解，因为有很多都是自由变量，随便取值的，这么一组合不就无穷多了？
        }

//        scpro.write("之前：\n");
//        out();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
//        scpro.write("之后：\n");
//        out();

        return 0; // 有唯一解

    }

    private static void out() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                scpro.write(String.format("%10.2f", a[i][j]));
            }
            scpro.write("\n");
        }

        scpro.write("\n");
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
