package com.acwing;

import java.io.*;
import java.util.Arrays;

public class acwing4945 {

//    static final int N = 11;
    static int n, m, bx, by;


    public static class Read {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public long nextLong() throws IOException {
            st.nextToken();
            return (long) st.nval;
        }

        //只能读取纯字符串的方法
        public String readLine() throws IOException {    //	不推荐使用
            st.nextToken();
            return st.sval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public void write(Object o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static long hex(int[] str, int b) {
        long decimalValue = 0;
        for (int digitValue : str) {
            // 将每个位数转换为整数
            // 计算每个位数的值并将它们相加
            decimalValue = decimalValue * b + digitValue;
        }
        System.out.println(decimalValue);
        return decimalValue;

    }

    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        n = sc.nextInt();
        bx = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i ++ ){
            x[i] = sc.nextInt();
        }

        m = sc.nextInt();
        by = sc.nextInt();
        int[] y = new int[m];
        for (int i = 0; i < m; i ++ ){
            y[i] = sc.nextInt();
        }

//        long x2 = hex(x, bx);
//        long y2 = hex(y, by);
//
//
//        if (x2 < y2)
//            sc.write("<");
//        else if (x2 > y2)
//            sc.write(">");
//        else
//            sc.write("=");
        long x2 = hex(x, bx);
        long y2 = hex(y, by);

        int result = Long.compare(x2, y2);
        sc.write(result < 0 ? "<" : result > 0 ? ">" : "=");
    }
}
