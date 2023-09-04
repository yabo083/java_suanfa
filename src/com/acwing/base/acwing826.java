package com.acwing.base;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *数组模拟指针，idx初始化为1，e数组存值，ne数组存下一个节点的下标（索引）
 *用了ne数组的ne[0]为位置来当头节点（头指针），那么idx这个指针就不能再设为0，需要手动设下初值为1，
 * 而且还需在main函数里把ne[0]设为-1，职责迁移，但活没变，该初始化成什么样还是什么样。
 *最后一句话：涉及到‘指针’操作的，等号左边是变量，等号右边是值（看上去都是指针，但意义却不同呢）
 */
public class acwing826 {

    public static int N = 100010;

    public static int idx = 1;

    public static int[] e = new int[N], ne = new int[N];

    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }

    public static void remove(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) throws IOException {
        int m = scPro.nextInt();
        ne[0] = -1;
        while (m -- > 0){
            int k, x;
            String op = scPro.next();
            if ("H".equals(op)){
                x = scPro.nextInt();
                add(0, x);
            }else if ("D".equals(op)){
                k = scPro.nextInt();
                remove(k);
            }else {
                k = scPro.nextInt();
                x = scPro.nextInt();
                add(k, x);
            }

        }

        for (int i = ne[0]; i != -1; i = ne[i]){
            scPro.write(e[i] + " ");
        }
        scPro.pw.flush();


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
