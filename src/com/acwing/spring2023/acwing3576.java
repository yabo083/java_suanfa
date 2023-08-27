package com.acwing.spring2023;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class acwing3576 {

    static int N = 110;

    static int n, m;
    static int[] w = new int[N];
    static Integer[] v = new Integer[N];

    static int[][] cnt = new int[N][N];


    public static void main(String[] args) throws IOException {
        Arrays.fill(v, 1010);           //注意这里是关键，通过将默认值设置为较大值（其实只要比输入的数都大就行）
                                             //就可以避免0的干扰

        //读入并处理数据
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
                v[i] = w[i];
            }

            Arrays.sort(v);

            //这个方法必须实现两个功能：
            // 1. 对静态数组去重
            // 2. 结果要穿透不同的作用域, 但似乎传个全局变量的数组就行？
            m = distinct(v);

            for (int[] row : cnt) {
                Arrays.fill(row, 0);
            }

            //将数字录入矩阵
            int k = 0;
            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                k = Math.max(k, t);
                int j = 0;
                while (v[j] != w[i]) {
                    j++;
                }
                cnt[t][j]++;
            }

            //输出结果
            for (int i = 1; i <= k; i++) {
                sc.write(i + "={");
                for (int j = 0; j < m; j++) {
                    sc.write(v[j] + "=" + cnt[i][j]);
                    if (j == m - 1) {
                        sc.write("}");
                    } else {
                        sc.write(",");
                    }
                }
                sc.write("\n");
            }


        }
        sc.pw.flush();


    }

    /**
     * 可以对数组去重
     *
     * @param v 传入的数组必须有序
     * @return 返回的是数组存的元素种类
     */
    private static int distinct(Integer[] v) {
        int k = 0;
        for (int i = 1; i < v.length; i++) {
            if (!Objects.equals(v[k], v[i])) {
                v[++k] = v[i];
            }
        }
        return k;
    }

    static class sc {

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
