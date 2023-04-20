package com.acwing.spring2023;

import java.io.*;

public class acwing4964 {

    static int N = 1010, MOD = 998244353;

    static int n, m, A, B;

    static int[][] w = new int[N][N], rmax = new int[N][N], rmin = new int[N][N];//感觉对二维数组的了解增加了！就拿w[i]来说，每一个w[i]都是一个长度为N的子数组啊！

    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();

        for (int i = 0; i < n; i++) {                               //没什么好说的，录入矩阵罢了
            for (int j = 0; j < m; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {                               //这是预处理，最终算出了每行的每B列（这就是滑动窗口的长度哦）的最大值和最小值，
            get_max(w[i], rmax[i], m, B);                           //存在了rmax中，而且注意没形成滑动窗口之前存到rmax的最值没意义，所以下面也没用的的上它们。
            get_min(w[i], rmin[i], m, B);
        }

        long res = 0;

        int[] a = new int[N], b = new int[N], c = new int[N];       //临时数组，a暂存最大或最小值...是矩阵从上往下的每一行的最值。
        for (int i = B - 1; i < m; i++) {                           //而且这时候，列也开始准备以长为B的滑动窗口开始遍历
            for (int j = 0; j < n; j++) {
                a[j] = rmax[j][i];
            }
            get_max(a, b, n, A);                                    //b接过了a，接下了总共n行之中，A行中的最大值
            for (int j = 0; j < n; j++) {
                a[j] = rmin[j][i];
            }
            get_min(a, c, n, A);                                    //c接过了a，接下了总共n行之中，A行中的最小值
            for (int j = A - 1; j < n; j++) {
                res = (res + (long) b[j] * c[j]) % MOD;             //球进了...（bushi）从上到下地，以A行为长度的子矩阵就形成了，联系外层for循环，
            }                                                       //这正是，第一组A行B列的子矩阵，而且最大值存在b中，最小值存在c中，算就行了！
        }

        sc.write(res);
    }

    private static void get_max(int[] a, int[] b, int tot, int k) {
        int hh = 0, tt = -1;
        for (int i = 0; i < tot; i++) {
            if (hh <= tt && q[hh] <= i - k) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }
            q[++tt] = i;
            b[i] = a[q[hh]];                                    //不用奇怪，为什么不是达到窗口长度在录入，其实...无所谓，反正到时候也不用
        }

    }

    private static void get_min(int[] a, int[] b, int tot, int k) {
        int hh = 0, tt = -1;
        for (int i = 0; i < tot; i++) {
            if (hh <= tt && q[hh] <= i - k) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }
            q[++tt] = i;
            b[i] = a[q[hh]];                                    //同理
        }

    }

    static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }


}
