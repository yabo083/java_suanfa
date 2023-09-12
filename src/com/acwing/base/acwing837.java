package com.acwing.base;

import java.io.*;
import java.util.StringTokenizer;

public class acwing837 {

    public static int N = 100010;

    public static int[] p = new int[N], cnt = new int[N];

    public static void main(String[] args) {
        int n = scpro.nextInt(), m = scpro.nextInt();

        for (int i = 1; i <= n; i++) {
            p[i] = i;
            cnt[i] = 1;
        }

        while (m-- > 0) {
            String op = scpro.next();
            if ("C".equals(op)) {
                int a = scpro.nextInt(), b = scpro.nextInt();
                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    cnt[b] += cnt[a];
                }
            } else if ("Q1".equals(op)) {
                int a = scpro.nextInt(), b = scpro.nextInt();
                if (find(a) == find(b)) {
                    scpro.write("Yes"+ "\n");
                } else {
                    scpro.write("No"+ "\n");
                }
            } else {
                int a = scpro.nextInt();
                scpro.write(cnt[find(a)] + "\n");
            }
        }
        scpro.pw.flush();
    }

    private static int find(int x) {
        return p[x] != x ? p[x] = find(p[x]) : p[x];
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

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }

}
