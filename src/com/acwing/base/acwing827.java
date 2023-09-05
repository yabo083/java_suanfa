package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing827 {

    public static int N = 100010;

    public static int[] e = new int[N], l = new int[N], r = new int[N];

    public static int idx = 2;


    public static void main(String[] args) throws IOException {
        int m = scPro.nextInt();
        r[0] = 1;
        l[1] = 0;
        int idx = 2;

        while (m-- > 0) {
            String op = scPro.next();
            int k, x;
            if (op.equals("L")) {
                x = scPro.nextInt();
                new acwing827().insert(0, x);
            } else if (op.equals("R")) {
                x = scPro.nextInt();
                new acwing827().insert(l[1], x);
            } else if (op.equals("D")) {
                k = scPro.nextInt();
                remove(k + 1);
            } else if (op.equals("IL")) {
                k = scPro.nextInt();
                x = scPro.nextInt();
                new acwing827().insert(l[k + 1], x);
            } else if (op.equals("IR")) {
                k = scPro.nextInt();
                x = scPro.nextInt();
                new acwing827().insert(k + 1, x);
            }
        }

        for (int i = r[0]; i != 1; i = r[i])
            scPro.write(e[i] + " ");

        scPro.pw.flush();

    }

    private static void remove(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

    private void insert(int k, int x) {
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx++;
    }

    static class scPro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scPro() throws IOException {
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
