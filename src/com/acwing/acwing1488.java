package com.acwing;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class acwing1488 {

    static int N = 100010, M = 3 * N, inf = 0x3f3f3f3f, idx, n, m, dummy_s;
    static int[] h = new int[N],
                e = new int[M],
                ne = new int[M],
                w = new int[M],
                dist = new int[N];
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c){
        //每行写注释
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    //

    static void dijkstra(){

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Arrays.fill(dist, inf);
        dist[dummy_s] = 0;
        heap.offer(new int[]{dummy_s, 0});

        while (heap.size() > 0){
            int[] t = heap.poll();
            int ver = t[0], distance = t[1];
            if(st[ver]) continue;
            st[ver] = true;
            for (int i = h[ver]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    heap.offer(new int[]{j, dist[j]});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while(m -- != 0){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        dummy_s = n + 1;
        m = sc.nextInt();
        while(m -- != 0){
            int x = sc.nextInt();
            add(dummy_s, x, 0);
        }

        dijkstra();

        m = sc.nextInt();
        while (m -- != 0){
            int x = sc.nextInt();
            sc.write(Optional.of(dist[x]));
        }

        sc.pw.flush();

    }

    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

        //快读一个整数
        public int nextInt() throws Exception{
            st.nextToken();
            return (int) st.nval;
        }
        //写一个快写任何类型的方法
        public void write(Object o) throws Exception{
            pw.println(o);
        }

    }
}
