package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class acwing847 {

    public static int N = 100010;

    public static int n, m, idx;

    public static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(a,b);
        }

        sc.write(bfs());
        sc.pw.flush();
    }

    private static int bfs() {
        Arrays.fill(d, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        d[1] = 0;
        q.addLast(1);

        while (!q.isEmpty()){
            int t = q.removeFirst();

            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (d[j] == -1){
                    d[j] = d[t] + 1;
                    q.addLast(j);
                }
            }
        }

        return d[n];


    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
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
