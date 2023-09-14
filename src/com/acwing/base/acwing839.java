package com.acwing.base;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class acwing839 {

    public static int N = 100010;

    public static ArrayList<Integer> hp = new ArrayList<>(Collections.nCopies(N, 0));
    public static ArrayList<Integer> ph = new ArrayList<>(Collections.nCopies(N, 0));
    public static ArrayList<Integer> h = new ArrayList<>(Collections.nCopies(N, 0));

    public static int cnt = 0;

    public static void main(String[] args) {
        int n = scpro.nextInt(), m = 0;
        while (n-- > 0) {
            String op = scpro.next();
            if ("I".equals(op)) {
                int x = scpro.nextInt();
                cnt++;
                m++;
                ph.set(m, cnt);
                hp.set(cnt, m);
                h.set(cnt, x);
                up(cnt);
            } else if ("PM".equals(op)) {
                scpro.write(h.get(1));
            } else if ("DM".equals(op)) {
                heap_swap(1, cnt);
                cnt--;
                down(1);
            } else if ("D".equals(op)) {
                int k = scpro.nextInt();
                k = ph.get(k);
                heap_swap(k, cnt);
                cnt--;
                up(k);
                down(k);
            } else {
                int k = scpro.nextInt(), x = scpro.nextInt();
                k = ph.get(k);
                h.set(k, x);
                up(k);
                down(k);
            }
        }
        scpro.pw.flush();
    }

    private static void heap_swap(int a, int b) {
        Collections.swap(ph, hp.get(a), hp.get(b));
        Collections.swap(hp, a, b);
        Collections.swap(h, a, b);
    }

    private static void up(int u) {
        int t = u;
        if (u / 2 >= 1 && h.get(u / 2) > h.get(t)) { // ">" ==> 小根堆，"<" == >大根堆.
            t = u / 2;
        }
        if (u != t) {
            heap_swap(u, t);
            up(t);
        }
    }

    private static void down(int u) {
        while (true) {
            int t = u;
            if (u * 2 <= cnt && h.get(u * 2) < h.get(t)) { // "<" ==> 小根堆，">" == >大根堆.
                t = u * 2;
            }
            if (u * 2 + 1 <= cnt && h.get(u * 2 + 1) < h.get(t)) { // "<" ==> 小根堆，">" == >大根堆.
                t = u * 2 + 1;
            }
            if (u != t) {
                heap_swap(u, t);
                u = t;
            } else {
                break;
            }
        }
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
            pw.println(o);
        }

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }

}
