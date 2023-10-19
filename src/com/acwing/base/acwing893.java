package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class acwing893 {

    public static int N = 110, M = 100010;

    public static int n, m;

    public static int[] s = new int[N], f = new int[M];

    public static void main(String[] args) throws IOException {
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
        }

        n = sc.nextInt();
        Arrays.fill(f, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            res ^= sg(x);
        }
        if (res != 0) {
            sc.write("Yes\n");
        } else {
            sc.write("No");
        }
        sc.pw.flush();
    }

    private static int sg(int x) {
        if (f[x] != -1) {
            return f[x];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int sum = s[i];
            if (x >= sum) {
                set.add(sg(x - sum));
            }
        }

        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return f[x] = i;
            }
        }

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
