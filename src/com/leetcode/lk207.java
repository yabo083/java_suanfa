package com.leetcode;

import java.util.Arrays;

class lk207 {

    static int N = 100010;
    static int n, m, idx = 0;
    static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], q = new int[N];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(h, 0, numCourses + 1, -1);
        int length = prerequisites.length;
        for (int i = 0; i < length; i ++){
            int a = prerequisites[i][1], b = prerequisites[i][0];
            add(a, b);
            d[b] ++;
        }

        return topSort();

    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    boolean topSort(){
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i ++){
            if(d[i] == 0) q[++ tt] = i;
        }

        while (hh <= tt){
            int t = q[hh ++];
            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(-- d[j] == 0) q[++ tt] = j;
            }
        }
        return tt == n - 1;
    }
}
