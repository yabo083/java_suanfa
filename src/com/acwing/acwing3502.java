package com.acwing;

import java.util.HashSet;
import java.util.Scanner;

public class acwing3502 {

    private static final int N = 10;

    static int n, m , k;
    static int[][] g = new int[N][N];
    static HashSet<Integer> S = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int u, int num){
        if(u == k ) S.add(num);
        else {
            for (int i = 0; i < 4; i ++){
                int a = x + dx[i], b = y + dy[i];
                if(a >= 0 && a < n && b >= 0 && b < m)
                    dfs(a, b, u + 1, num * 10 + g[a][b]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n ; i ++ )
            for (int j = 0; j < m; j ++)
                g[i][j] = sc.nextInt();

        for(int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j ++)
                dfs(i, j, 0 , g[i][j]);

        System.out.println(S.size());

    }

}
