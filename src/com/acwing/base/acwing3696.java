package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acwing3696 {

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

    private static final int N = 200010, M = N;

    static int n, m, idx, cnt;
    static int[]
        h = new int[N],
        e = new int[N],
        ne = new int[M],
        q = new int[N],
        d = new int[N],
        pos = new int[N];

    static class Edge{
        int a, b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static Edge[] edge = new Edge[M];

    static void add(int a, int b)
    {
//      经典头插法
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topsort() {
        int hh = 0, tt = -1;

        for (int i = 1; i <= n; i ++)
            if (d[i] == 0) q[++ tt] = i;

        while (hh <= tt) {
            int t = q[hh ++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(-- d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }
        return tt == n - 1;
    }

    public static void main(String[] args) throws Exception {
        Read sc = new Read();
        int T = sc.nextInt();
        while ( T -- > 0 ){
            n = sc.nextInt();
            m = sc.nextInt();
            Arrays.fill(h, 0, n + 1, -1);
            Arrays.fill(d, 0, n + 1, 0);
            idx = 0;cnt = 0;

            while (m -- > 0){
                int t, a ,b;
                t = sc.nextInt();
                a = sc.nextInt();
                b = sc.nextInt();
                if (t == 0) {
                    edge[cnt ++] = new Edge(a, b);
                } else {
                    add(a, b);
                    d[b] ++;
                }
            }

            if (!topsort()) {
                sc.write("NO");
                sc.pw.flush();
            }else {
                sc.write("YES");
                for (int i = 1; i <= n; i ++)
                    for (int j = h[i]; j != -1; j = ne[j]) {
//                        System.out.println(i + " " + e[j]);
                        sc.write(i + " " + e[j]);
                        sc.pw.flush();
                    }

                for (int i = 0; i < n; i ++ ) pos[q[i]] = i;
                for (int i = 0; i < cnt; i ++ )
                {
                    int a = edge[i].a, b = edge[i].b;
                    if (pos[a] > pos[b]) {
                        int tmp = a;
                        a = b;
                        b = tmp;
                    }
//                    System.out.println(a + " " + b);
                    sc.write(a + " " + b);
                    sc.pw.flush();
                }
            }
        }
    }




}
