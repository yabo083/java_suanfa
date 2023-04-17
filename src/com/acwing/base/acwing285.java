package com.acwing.base;
import java.util.*;
public class acwing285 {

        static final int N = 6010;
        static int n, idx;
        static int[] h = new int[N], e = new int[N], ne = new int[N], happy = new int[N];
        static int[][] f = new int[N][2];
        static boolean[] has_fa = new boolean[N];

        static void add(int a, int b){
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx ++;
        }

        static void dfs(int u){
            f[u][1] = happy[u];

            for (int i = h[u]; i != -1 ;i = ne[i] ){

                int j = e[i];
                dfs(j);
                f[u][1] += f[j][0];
                f[u][0] += Math.max(f[j][0], f[j][1]);
            }


        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            for (int i = 1; i <= n; i ++ ){
                happy[i] = sc.nextInt();
            }

            Arrays.fill(h, -1);
            for (int i = 0; i < n - 1; i ++ ){
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                add(b, a);
                has_fa[a] = true;
            }

            int root = 1;
            while(has_fa[root]) root ++;

            dfs(root);

            System.out.println(Math.max(f[root][0], f[root][1]));
        }

    }

