package com.competition.chaunzhi;

import java.io.*;
import java.util.StringTokenizer;

public class dcs {

    public static int N = 110;
    public static char[] str1 = new char[N], str2 = new char[N];

    public static void main(String[] args) throws IOException {
        str1 = scpro.readLine().toCharArray();
        str2 = scpro.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str1.length; i++) {
            int flag = 0;
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                sb.append(str1[i]);
            }
        }
        scpro.write(sb.toString());
        scpro.pw.flush();
    }


    public static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer，相比于readline读一行，这个方法可以读混合字符串和数字的一行而且只读取字符串。
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
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.print(o);
        }

    }

}
