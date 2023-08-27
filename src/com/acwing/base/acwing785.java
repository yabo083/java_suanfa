package com.acwing.base;

import java.io.*;

public class acwing785 {

    public static int N = 100010;
    public static int[] q = new int[N];

    public static void quick_sort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        //大概流程懂了，另外研究了下为什么不直接使用l，r而是通过-1+1来从一个虚拟的头和尾走起。
        //只能说确实有道理，在拿[2,1]脑测时发现很快就越界寄了！
        int i = l - 1, j = r + 1, x = q[(l + r) >> 1];
        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                q[i] = q[i] ^ q[j];
                q[j] = q[j] ^ q[i];
                q[i] = q[i] ^ q[j];
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        quick_sort(q, 0, n - 1);
        for (int i = 0; i < n; i++) {
            sc.write(q[i] + " ");
        }
        sc.pw.flush();
    }

    static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
            pw.flush();
        }


    }


}


