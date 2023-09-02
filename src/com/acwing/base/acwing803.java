package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class acwing803 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        Pair[] segs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            segs[i] = new Pair(l, r);
        }
        sc.write(merge(segs, n));
        sc.pw.flush();

    }

    private static int merge(Pair[] segs, int n) {
        Arrays.sort(segs, Comparator.comparingInt(a -> a.l));
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < segs[i].l) {
                cnt++;
            }
            max = Math.max(max, segs[i].r);
        }
        return cnt;
    }

    public static class Pair {

        int l, r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
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
