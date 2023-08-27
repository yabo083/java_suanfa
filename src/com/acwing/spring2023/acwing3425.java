package com.acwing.spring2023;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acwing3425 {

    static int N = 110, n;

    static mouse[] w = new mouse[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer weight = sc.nextInt();
            String c = sc.next();
            w[i] = new mouse(weight, c);
        }

        Arrays.sort(w, 0, n);

        for (int i = n - 1; i >= 0; i--) {
            sc.write(w[i].color);
        }
        sc.pw.flush();


    }

    static class mouse implements Comparable<mouse> {

        Integer weight;
        String color;

        public mouse(Integer weight, String c) {
            this.weight = weight;
            this.color = c;
        }

        @Override
        public int compareTo(mouse o) {
            return this.weight - o.weight;
        }

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
            pw.println(o);
//            pw.flush();
        }


    }

}
