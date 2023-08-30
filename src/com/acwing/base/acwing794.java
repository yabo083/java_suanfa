package com.acwing.base;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class acwing794 {

    public static BigDecimal[] divideAndRemainder(BigDecimal a, BigDecimal b) {
        return a.divideAndRemainder(b);
    }

    static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer
        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数

        //这下换成br，就可以读任意类型的字符串了
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }




    }

    public static void main(String[] args) throws IOException {
        BigDecimal a = new BigDecimal(scpro.readLine());
        BigDecimal b = new BigDecimal(scpro.readLine());
        BigDecimal[] ans = divideAndRemainder(a, b);
        scpro.write(ans[0]);
        scpro.write(ans[1]);
        scpro.pw.flush();
    }

}
