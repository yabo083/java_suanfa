package com.tools;

import java.io.*;
import java.util.StringTokenizer;

class ReadAndWrite {

    /**
     * 高精度快读快写
     */
    static class HighPrecisioRead {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        HighPrecisioRead() throws IOException {}

        //read类升级，由StreamTokenizer变成StringTokenizer
        String next() {
            while (st==null||!st.hasMoreElements()){
                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数
        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    /**
     * 极简版快读快写，常用
     */
    public static class Read {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public <T> void write(T o) {
            pw.print(o + " ");

        }


    }


    /**
     * 静态极简版快读快写，可以直接用
     */
    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static  <T> void write(T o) {
            pw.print(o);
        }


    }

    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        //生成read所有方法的测试用例


    }
}

