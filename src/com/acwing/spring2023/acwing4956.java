package com.acwing.spring2023;

import java.io.*;

public class acwing4956 {

    static int[] a = new int[10010];
    static int[] b = new int[10010];

    static int get(int a, int b) {
        int l = 1, r = (int) 1e9 + 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (a / mid <= b) r = mid;
            else l = mid + 1;
        }
        return r;

    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int v_min = 1;
        int v_max = (int) 1e9;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v_min = Math.max(v_min, get(a[i], b[i]));
            v_max = Math.min(v_max, get(a[i], b[i] - 1) -1);
        }
//        while (n-- > 0) {
//            int a = sc.nextInt(), b = sc.nextInt();
//            v_min = Math.max(v_min, get(a, b));
//            v_max = Math.min(v_max, get(a, b - 1) - 1);
//        }
        sc.write(v_min + " ");
        sc.write(v_max);
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
        }


    }

}
