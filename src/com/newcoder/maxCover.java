package com.newcoder;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class maxCover {

    public static int n;

    public static class Pair {
        int l, r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static Pair[] pairs;

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

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(pairs, Comparator.comparing(a -> a.l));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && pairs[i].l >= heap.peek()) {
                heap.poll();
            }
            heap.add(pairs[i].r);
            ans = Math.max(ans, heap.size());
        }
        sc.pw.write(ans + "\n");
        sc.pw.flush();
    }

}
