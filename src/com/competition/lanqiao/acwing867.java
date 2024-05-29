package com.competition.lanqiao;

import java.io.*;

public class acwing867 {

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

    static void divide(int x) {
        for (int i = 2; i <= x / i; i++)
            if (x % i == 0){
                int s = 0;
                while(x % i == 0){
                    x /=i;
                    s ++;
                }
                sc.write(i + " " + s + "\n");

            }
        if (x > 1) sc.write(x + " " + 1 + "\n");
        sc.write("\n");
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n -- > 0){
            int x = sc.nextInt();
            divide(x);
        }
        sc.pw.flush();
    }

}
