package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing3384 {

    static int N = 110, idx;
    static char[] a = new char[N];

    static class Tree {
        Tree left, right;
        char var;

        public Tree(char var) {
            this.var = var;
        }
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
//            pw.flush();
        }


    }


    //建树
    public static Tree build() {
        char var = a[idx++];
        if (var == '#') return null;

        Tree t = new Tree(var);
        t.left = build();
        t.right = build();
        return t;
    }

    //中序遍历树，实质是dfs，只不过是在哪输出而已
    public static void dfs_mid_order(Tree t) {
        if (t == null) return;
        dfs_mid_order(t.left);
        scPro.write(t.var + " ");
        dfs_mid_order(t.right);
    }

    public static void main(String[] args) throws IOException {
        a = scPro.readLine().toCharArray();
        dfs_mid_order(build());
        scPro.pw.flush();

    }







}
