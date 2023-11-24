package com.acwing.base;

import java.io.*;

public class acwing895 {

    public static int N = 100010;

    public static int n;
    public static int[] a = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int len = 0;
        q[0] = (int) (-10e9 - 10); // 因为下面用if把逻辑剥离了出来，所以为了第一个数可以正确落到序列中，需要设为最小值
        for (int i = 0; i < n; i++) {
            if (a[i] > q[len]) {
                q[++len] = a[i];
            } else {
                int j = find(len, i);
                q[j] = a[i];
            }
        }
        sc.write(len);
        sc.pw.flush();
    }

    private static int find(int len, int i) {
        int l = 0, r = len - 1; // -1是闭区间，不-1是左闭右开区间，但只要包含了全部的元素，那就没问题
        while (l < r) {
            int mid = l + r >> 1; // 加1就是取右端点，不加1就是取左端点，下面怎么写按你想的来就行，不过我要提醒你
                                  // mid加了1，那下面照你想的写完后，记得同减个1。然后就行了。
            if (q[mid] < a[i]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
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
