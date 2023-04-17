package com.acwing.base;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class acwing1460 {

    public static int main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.nextLine();

        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l ) / 2;
            if(check(mid, s)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    static boolean check(int mid, String s) {
        Set set = new HashSet();

        for( int i = 0; i + mid -1 <  s.length(); i ++ ) {
            String t = s.substring(i, i+mid);
            if(set.contains(t)) return false;
            set.add(t);
        }
        return true;
    }


}
