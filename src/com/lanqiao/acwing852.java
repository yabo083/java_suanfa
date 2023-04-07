package com.lanqiao;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class acwing852 {

    static int N = 2010, M = 10010;

    static int n, m, idx;
    static int[] h = new int[N], w = new int[M], e = new int[M], ne = new int[M], dist = new int[N], cnt = new int[N];

    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean spfa() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st[i] = true;
            q.add(i);
        }

        while (q.size() != 0){

            int t = q.poll();

            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;

                    if (cnt[j] >= n) return true;
                    if (!st[j]){
                        q.add(j);
                        st[j] = true;
                    }
                }
            }

        }

        return false;
    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);

        while (m -- > 0){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b,c);
        }

        if (spfa()) sc.write("Yes");
        else sc.write("No");
    }


}
