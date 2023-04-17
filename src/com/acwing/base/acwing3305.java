package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;


public class acwing3305 {

    private static final int N = 2010, M = 200010;

    static int n, m, k, T, idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[N], target = new int[M], dist = new int[N];
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c){
        e[idx] = b;
        target[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static void spfa(){
        while (!q.isEmpty()){
            int x = q.poll();
            st[x] = false;

            for (int i = h[x]; i != -1; i = ne[i]){
                int y = e[i], z = target[i];
                if (dist[z] > Math.max(dist[x], dist[y]) + Math.max(w[x], w[y])){
                    dist[z] = Math.max(dist[x], dist[y]) + Math.max(w[x], w[y]);
                    if (!st[z]){
                        q.add(z);
                        st[z] = true;
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        T = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i ++)
            w[i] = sc.nextInt();

        Arrays.fill(dist, 0x3f3f3f3f);
        while (m -- != 0){
            int x  = sc.nextInt();
            dist[x] = 0;
            q.add(x);
            st[x] = true;
        }

        while (k -- != 0){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        spfa();

        sc.write(Optional.of(dist[T]));
        sc.pw.flush();
    }

    static class Read{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

        public int nextInt() throws Exception{
            st.nextToken();
            return (int) st.nval;
        }

        public void write(Object o) throws Exception{
            pw.println(o);
        }
    }


}
