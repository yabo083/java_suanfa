package com.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class acwing3768 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        int res = 0;
        for(int i = 0; i < n; i ++){
            if(s[i] != 'x') continue;
            int j = i;
            while (j < n && s[j] == 'x') j ++ ;
            res += Math.max(0, j - i - 2);
            i = j;
        }
        System.out.println(res);
    }

}
