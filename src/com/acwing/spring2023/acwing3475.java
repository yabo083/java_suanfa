package com.acwing.spring2023;

import java.io.*;
import java.util.StringTokenizer;

public class acwing3475 {

    public static void main(String[] args) throws IOException {
        while (true){
            String st = sc.readLine();
            if ("ENDOFINPUT".equals(st)){
                break;
            }
            String text = sc.readLine();
            sc.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (Character.isLetter(c)) sb.append((char)((c - 'A' - 5 + 26) % 26 + 'A'));
                else sb.append(c);
            }
            sc.write(sb.toString() + "\n");
        }
        sc.pw.flush();
    }

    static class sc {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        sc() throws IOException {
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

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }



    }

}
