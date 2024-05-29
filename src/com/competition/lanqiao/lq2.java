package com.competition.lanqiao;

import java.util.Scanner;

public class lq2 {

    static final int N = 5;

    static int res;
    static char[] c = new char[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i ++ ){
            c = sc.next().toCharArray();
            if (c[0] == c[2] && c[1] == (c[3] - 1))
                res ++;
        }

        System.out.println(res);

    }
}
