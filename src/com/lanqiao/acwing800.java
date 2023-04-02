package com.lanqiao;

import java.io.*;



public class acwing800 {

    static int N = 100010;

    static int[] a = new int[N], b = new int[N];

    static int n, m, x;

    public static void main(String[] args) throws IOException {

        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int j = 0; j < m; j++)
            b[j] = sc.nextInt();

        //双指针
       for (int i = 0, j = m - 1; i < n; i++) {
           while (j >= 0 && a[i] + b[j] > x) j--;
           if (j >= 0 && a[i] + b[j] == x) {
               sc.write(i + " " + j);
               return;
           }
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
        public void write(Object o) {
            pw.println(o);
            pw.flush();
        }


    }




}
