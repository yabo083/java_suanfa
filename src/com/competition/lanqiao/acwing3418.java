package com.competition.lanqiao;

import java.io.*;

public class acwing3418 {

    public static class Read {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public long nextLong() throws IOException {
            st.nextToken();
            return (long) st.nval;
        }

        //只能读取纯字符串的方法
        public String readLine() throws IOException {    //	不推荐使用
            st.nextToken();
            return st.sval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    static int n;

    static Read sc;


    public static void main(String[] args) throws IOException {
        sc = new Read();
        n = sc.nextInt();
        for (int k = 16; k >= 0; k--) {
            if (check(k)) break;
        }

    }

    public static long C(long a, long b) {
        long res = 1;
        for (long i = a, j = 1; j <= b; i--, j++) {
            res = res * i / j;
            if (res > n) return res;
        }
        return res;

    }

    private static boolean check(int k) {
        long l = 2L * k;
        //这里将r设置为n（大多数情况如此），其实乍看你要算一个非常大的组合数
        //但经过取mid，和C函数中的特判，计算量和计算的组合数也没那么离谱
        //而且这只是初值，二分会不断缩短区间的，所以没问题
        long r = Math.max(n, l);
        while (l < r) {
            long mid = (l + ((r - l) >> 1));
            if (C(mid, k) >= n)
                r = mid;
            else
                l = mid + 1;
        }
        if (C(r, k) != n) return false;
        sc.write((r + 1) * r / 2 + k + 1);
        return true;
    }


}
