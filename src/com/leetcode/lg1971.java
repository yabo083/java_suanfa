package com.leetcode;

class lk1971 {

    int[] p;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        p = new int[n];
        for(int i = 0; i < n; i ++){
            p[i] = i;
        }
        for(int[] e: edges){
            p[find(e[0])] = find(e[1]);
        }

        return find(source) == find(destination);

    }

    public int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
