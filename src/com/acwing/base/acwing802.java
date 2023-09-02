package com.acwing.base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class acwing802 {

    public static final int N = 300010;

    public static int[] a = new int[N], s = new int[N];
    public static List<Integer> alls = new ArrayList<>();
    public static ArrayList<Pair> adds = new ArrayList<>(), querys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), c = sc.nextInt();
            adds.add(new Pair(x, c));
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            querys.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        alls = alls.stream().sorted().distinct().collect(Collectors.toList());

        for (Pair item : adds){
            int x = find(item.first);
            a[x] += item.second;
        }

        for (int i = 1; i <= alls.size(); i ++) s[i] = s[i - 1] + a[i];

        for (Pair item : querys){
            int l = find(item.first), r = find(item.second);
            sc.write(s[r] - s[l - 1]+"\n");
        }
        sc.pw.flush();

    }

    public static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r + 1;
    }

    public static class Pair {

        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
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
