package com.acwing.base;

import java.io.*;

public class acwing830 {

    public static int tt = 0;

    public static void main(String[] args) throws IOException {

        int n = sc.nextInt();
        int[] stk = new int[n + 1];
        int[] s = new int[n + 1], m = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            while (tt != 0 && s[stk[tt]] <= s[i]) {
                tt--;
            }
            if (tt != 0) {
                m[i] = stk[tt];
            } else {
                m[i] = 0;
            }
            stk[++tt] = i;
        }

        for (int i = 1; i <= n; i++) {
            sc.write(m[i] + " ");
        }
        sc.pw.flush();
    }

//    public static void main(String[] args) throws IOException {
//        int n = sc.nextInt();
//        while (n-- > 0){
//            int x = sc.nextInt();
//            while (tt != 0 && stk[tt] >= x) tt --;//维持了一个单调递增栈
//            if (tt == 0) sc.write("-1 ");
//            else sc.write(stk[tt]+ " ");
//            stk[++ tt] = x;
//        }
//        sc.pw.flush();
//    }

    public static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }

}
