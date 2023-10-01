package com.acwing.base;

import java.io.*;
import java.util.TreeSet;

public class acwing869 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

        while (n-- > 0) {
            int x = sc.nextInt();
            TreeSet<Integer> res = get_divisors(x);
            //打印结果
            for (Object o : res) {
                sc.write(o + " ");
            }
            sc.write("\n");
            sc.pw.flush();

        }
    }

    private static TreeSet<Integer> get_divisors(int x) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                res.add(i);
                res.add(x / i);
            }
        }
        return res;

    }

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
