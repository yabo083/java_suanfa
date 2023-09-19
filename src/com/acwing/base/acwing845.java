package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class acwing845 {


    public static void main(String[] args) throws IOException {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            str.append(scpro.next());
        }
        scpro.write(bfs(str.toString()));
        scpro.pw.flush();
    }

    private static int bfs(String str) {
        ArrayDeque<String> q = new ArrayDeque<>();
        HashMap<String, Integer> d = new HashMap<>();

        q.addLast(str);
        d.put(str, 0);

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        String end = "12345678x";
        while (!q.isEmpty()) {
            String t = q.removeFirst();

            if (end.equals(t)) {
                return d.get(t);
            }

            int distance = d.get(t);
            int k = t.indexOf("x");
            int x = k / 3, y = k % 3;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    t = swap(t, a, b, k);
                    if (!d.containsKey(t)) { // 比较的应该是字符串的内容！
                        d.put(t, distance + 1);
                        q.addLast(t);
                    }
                    t = swap(t, a, b, k);
                }
            }
        }
        return -1;


    }

    private static String swap(String t, int a, int b, int k) {

        StringBuilder str = new StringBuilder(t);

        char tmp = str.charAt(a * 3 + b);
        str.setCharAt(a * 3 + b, t.charAt(k)); // 把 x 赋给 上下左右某个位置
        str.setCharAt(k, tmp); // 交换成功！

        return str.toString();
    }

    private static StringBuilder swap(StringBuilder t, int a, int b, int k) {
        char tmp = t.charAt(a * 3 + b);
        t.setCharAt(a * 3 + b, t.charAt(k)); // 把 x 赋给 上下左右某个位置
        t.setCharAt(k, tmp); // 交换成功！
        return t;
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
//
//        //用来判断是否有未读取的数据
//        static boolean hasNext() throws IOException {
//            return br.ready();
//        }


    }

}
