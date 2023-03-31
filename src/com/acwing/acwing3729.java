package com.acwing;

import java.util.Scanner;
import java.util.Arrays;

public class acwing3729 {

    public static void main(String[] args) {
        int N = 200010;
        int[] a = new int[N];

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T -- != 0  ){
            Arrays.setAll(a, i -> 0);
            int n = in.nextInt();
            for(int i = 1; i <= n; i++) {
                int x = in.nextInt();
                x = Math.min(x, i);
                int l = i - x + 1;
                int r = i;
                a[l] ++ ;
                a[r + 1] -- ;
            }
            for(int i = 1; i <= n; i++) {
                a[i] += a[i - 1];
            }
            for(int i = 1; i <= n; i ++) {
                System.out.print(a[i] > 0 ? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
