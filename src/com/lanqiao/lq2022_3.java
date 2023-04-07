package com.lanqiao;

import java.io.*;
import java.util.StringTokenizer;

public class lq2022_3 {

    static class sc {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        sc() throws IOException {}

        //read类升级，由StreamTokenizer变成StringTokenizer
        static String next() {
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
        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
        static double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        public static String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        static public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        while (T -- > 0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = b - a;// Math.abs返回数的绝对值
            long d = c - (a % c);
            System.out.println(d);
        }

    }

}
