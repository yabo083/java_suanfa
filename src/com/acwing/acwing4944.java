package com.acwing;

import java.io.*;


public class acwing4944 {



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
            pw.print(o + " ");
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.write(Math.min(a, b));
        sc.write((int)Math.floor( Math.abs(a - b) / 2.0));
    }


}
