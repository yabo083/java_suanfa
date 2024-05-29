package com.competition.lanqiao;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class acwing851 {

    static int N = 100010;

    static int n, m, idx;

    static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N], dist = new int[N];

    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static int spfa(){
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        st[1] = true;

        while (q.size() != 0){

            int t = q.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if (!st[j]){
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }

        return dist[n];
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
            add(a, b, c);
        }

        int t = spfa();

        if (t == 0x3f3f3f3f) sc.write("impossible");
        else sc.write(t);
    }


}
