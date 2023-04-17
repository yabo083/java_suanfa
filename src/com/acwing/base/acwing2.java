package com.acwing.base;

import java.io.*;
import java.util.Optional;

public class acwing2 {
    static int N = 1010;

    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) throws Exception {
        Read bf = new Read();
//        Scanner bf = new Scanner(System.in);
        n = bf.nextInt();
        m = bf.nextInt();
        for (int i = 1; i <= n; i ++) {
            v[i] = bf.nextInt();
            w[i] = bf.nextInt();
        }

        for (int i = 1; i <= n; i ++){
            for (int j = 0; j <= m; j ++ ){
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i-1][j - v[i]] + w[i]);
            }
        }

//        System.out.println(f[n][m]);
        bf.write(f[n][m]);
        bf.pw.flush();


    }
    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

        //快读一个整数
        public int nextInt() throws Exception{
            st.nextToken();
            return (int) st.nval;
        }
        //写一个快写任何类型的方法
        public void write(Object o) throws Exception{
            pw.println(o);
        }

    }
}
