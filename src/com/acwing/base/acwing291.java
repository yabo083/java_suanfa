package com.acwing.base;

import java.util.Arrays;
import java.util.Scanner;

public class acwing291 {

    static int N = 12, M = 1 << N;
    static long[][] f = new long[N][M];
    static int[][] state = new int[M][M];
    static boolean[] st = new boolean[M];

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            n = sc.nextInt();
            m = sc.nextInt();

            if (n == 0 || m == 0)
                break;

            for (int i = 0; i < (1 << n); i ++){
                int cnt = 0;
                boolean isValid = true;
                for (int j = 0; j < n; j ++){
                    if (((i >> j) & 1) == 1) {
                        if ((cnt & 1) == 1) {
                            isValid = false;
                            break;
                        }
                        cnt = 0;
                    }else {
                        cnt ++;
                    }
                }

                if ((cnt & 1) == 1)
                    isValid = false;

                st[i] = isValid;
            }

            for (int j = 0; j < (1 << n); j ++){

                Arrays.fill(state[j], 0);

                for (int k = 0; k < (1 << n); k ++){
                    if ((j & k) == 0 && st[j | k]){
                        state[j][k] = 1;
                    }
                }
            }


            for(int i = 0 ; i < N ; i ++ )
                Arrays.fill(f[i],0);

            f[0][0] = 1;

            for(int i = 1 ; i <= m ; i ++ ){
                for(int j = 0 ; j < 1 << n ; j ++ ){
                    for(int k = 0 ; k < 1 << n ; k ++ ){
                        if(state[j][k] == 1) f[i][j] += f[i - 1][k];
                    }
                }
            }

            System.out.println(f[m][0]);
        }
    }
}
