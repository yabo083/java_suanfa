package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing4 {

    public static int N = 110;
    public static int n, m;
    public static int[] v = new int[N], w = new int[N], s = new int[N];
    public static int[] f = new int[N];


    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int sum = Arrays.stream(s).sum();
        int[] ww = new int[sum + 1];
        int[] vv = new int[sum + 1];

        // 下面是拆成一个一个的包的代码
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < s[i]; j++) {
                vv[num] = v[i];
                ww[num++] = w[i];
            }
        }

//        for (int i = 1; i < num; i ++){
//            sc.write("体积：" + vv[i] + " 价值：" + ww[i] + "\n");
//        }

        for (int i = 1; i < num; i++) {
            for (int j = m; j >= vv[i]; j--) {
                f[j] = Math.max(f[j], f[j - vv[i]] + ww[i]);
            }
        }
        sc.write(f[m]);
        sc.pw.flush();
    }

    public static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }

}
