package com.acwing.base;

import java.util.Arrays;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

public class acwing1562 {

    static int N = 10010, M = 100010;
    static int n, L, k, idx;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static boolean st[] = new boolean[N];

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(st,false);
        q.offer(start);
        st[start] = true;

        int res = 0;
        for (int i = 0; i < L; i ++){
            int size = q.size();
            while(size -- > 0){
                int t = q.poll();
                for (int j = h[t]; j != -1; j = ne[j]){
                    int x = e[j];
                    if(!st[x]){
                        q.offer(x);
                        st[x] = true;
                        res ++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();

        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i ++){
            int cnt = sc.nextInt();
            while(cnt -- > 0){
                int j = sc.nextInt();
                add(j, i);
            }
        }

        k = sc.nextInt();
        while(k -- > 0){
            int start = sc.nextInt();
            System.out.println(bfs(start));
        }
    }

}
