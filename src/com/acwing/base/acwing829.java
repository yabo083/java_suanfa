package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class acwing829 {

    public static int N = 100010;

    public static int[] q = new int[N];

    public static int hh = 0, tt = 0;

    public static void main(String[] args) {
        int m = scpro.nextInt();

//        while (m-- > 0) {
//            String op = scpro.next();
//            switch (op) {
//                case "push":
//                    int x = scpro.nextInt();
//                    q[tt++] = x;
//                    break;
//                case "pop":
//                    hh++;
//                    break;
//                case "empty":
//                    scpro.write((hh < tt ? "NO" : "YES") + "\n");
//                    break;
//                case "query":
//                    scpro.write(q[hh] + "\n");
//                    break;
//            }
//
//        }
        Deque<Integer> q = new ArrayDeque<>();
        while (m-- > 0){
            String op = scpro.next();
            switch (op){
                case "push":
                    int x = scpro.nextInt();
                    q.addLast(x);
                    break;
                case "pop":
                    q.pollFirst();
                    break;
                case "empty":
                    scpro.write((q.isEmpty() ? "YES" : "NO") + "\n");
                    break;
                case "query":
                    scpro.write(q.peekFirst() + "\n");
                    break;
            }
        }

        scpro.pw.flush();
    }

    public static class scpro {

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

