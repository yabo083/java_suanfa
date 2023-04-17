package com.acwing.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class acwing3777 {

    static int n;
    static String s = "";
    static char[] str = s.toCharArray();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while ( T -- != 0){
            n = in.nextInt();
            in.nextLine();
            s = in.next();
            if (!check(s,'W') && !check(s,'B')) {
                System.out.println(-1);
            }
        }
    }

    static boolean check(String s, char c){
        List<Integer> list = new ArrayList<>();
        str = s.toCharArray();
        for(int i = 0; i + 1 < n; i ++){
            if (str[i] != c) {
                update(i);
                update(i+1);
                list.add(i);
            }
        }
        if (str[n-1] != c) {
            return false;
        }

        System.out.println(list.size());
        for(int i : list) System.out.print(i + 1 + " ");
        if(list.size()!= 0) System.out.println();

        return true;

    }

    private static void update(int i) {
        if(str[i] == 'B') str[i] = 'W';
        else str[i] = 'B';
    }

}
