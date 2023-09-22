package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class acwing851 {

    public static int N = 100010;

    public static int n, m, idx;

    public static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N], dist = new int[N];

    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        Arrays.fill(h, -1);

        while (m -- > 0 ){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
        }

        int t = spfa();
        if (t == 0x3f3f3f3f) sc.write("impossible");
        else sc.write(t);

        sc.pw.flush();


    }

    private static int spfa() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        st[1] = true;

        while (!q.isEmpty()){
            int t = q.removeFirst();
            st[t] = false;

            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if(!st[j]){
                        q.addLast(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];

    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
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
