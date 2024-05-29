package com.competition.lanqiao;

import java.io.*;

public class acwing866 {

    static boolean is_prime(int x){
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i ++ )
            if (x % i == 0)
                return false;
        return true;
    }

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
            pw.println(o);
            pw.flush();
        }


    }
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n -- > 0){
            int x = sc.nextInt();
            if (is_prime(x)) sc.write("Yes");
            else sc.write("No");
        }
    }
}
