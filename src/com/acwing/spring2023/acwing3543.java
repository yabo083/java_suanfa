package com.acwing.spring2023;

import java.io.*;
import java.util.Arrays;

public class acwing3543 {

    static int N = 50, M = 210;

    static int n, m;

    static int[] w = new int[N], cnt = new int[M];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        while (n -- > 0) {
            m = sc.nextInt();

            Arrays.fill(cnt, 0);
            for (int i = 0; i < m; i ++){
                w[i] = sc.nextInt();
                cnt[w[i]] ++;               //关键就是这里的预处理。
            }

            int res = 0;
            for (int i = 0; i < m; i ++)
                for (int j = 0; j < m; j ++)
                    res += cnt[w[i] + w[j]];

            sc.write(res);
        }

        sc.pw.flush();
    }


    static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //写个读字符串
        public static String next() throws IOException {
            st.nextToken();
            return st.sval;
        }

        public static <T> void write(T o) {
            pw.println(o);
        }


    }

}
