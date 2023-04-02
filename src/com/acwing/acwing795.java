package com.acwing;

import java.io.*;

public class acwing795 {

    static int N = 100010;

    static long[] a = new long[N];

    static int n, m;

    public static void main(String[] args) throws IOException{
        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i ++) {
            a[i] = a[i - 1] + sc.nextInt();
        }
        while (m -- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            sc.write(a[r] - a[l - 1]);
        }


    }


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
        public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

}