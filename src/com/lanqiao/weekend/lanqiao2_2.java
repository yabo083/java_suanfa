package com.lanqiao.weekend;

import java.io.*;
import java.util.StringTokenizer;

public class lanqiao2_2 {

    public static void main(String[] args) throws IOException {
        int n = scpro.nextInt(), q = scpro.nextInt();
        while (q-- > 0) {
            String s = scpro.readLine();
            scpro.write(getNodeNumber(s)+"\n");
        }
        scpro.pw.flush();
    }

    private static int getNodeNumber(String s) {
        int nodeNumber = 1;
        for (char c : s.toCharArray()) {
            nodeNumber = nodeNumber * 2 + (c == 'R' ? 0 : -1);
        }
        return nodeNumber;
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

