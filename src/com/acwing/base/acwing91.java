package com.acwing.base;

import java.io.*;
import java.util.Arrays;

public class acwing91 {

    static final int N = 20, M = 1 << N;
    static int n;
    static int[][] w = new int[N][N], f = new int[M][N];

    public static void main(String[] args)throws IOException {
//        Scanner scPro = new Scanner(System.in);
        Read sc = new Read();
        n = sc.nextInt();
        for (int i = 0; i < n; i ++ ){
            for (int j = 0; j < n; j ++ ){
                w[i][j] = sc.nextInt();
            }
        }

        for (int[] row: f) {
            Arrays.fill(row, 0x3f3f3f3f);
        }

        f[1][0] = 0;

        for (int i = 1; i < (1 << n); i += 2) {
//            System.out.println(i);
            for (int j = 0; j < n; j ++ )
                if (((i >> j) & 1) == 1)
                    for (int k = 0; k < n; k ++ )
                        if (((i >> k) & 1) == 1)
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
        }


//        System.out.println(f[(1 << n) - 1][n - 1]);
        sc.write(f[(1 << n) - 1][n - 1]);
    }

    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

        //快读一个整数
        public int nextInt() throws IOException{
            st.nextToken();
            return (int) st.nval;
        }
        //写一个快写任何类型的方法
        public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }

    }



}
