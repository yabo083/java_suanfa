package com.lanqiao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class lq2021_2 {

    static long n = 2021041820210418L;

    static ArrayList<Long> list = new ArrayList<>();
    static void get_factor(){
        for (int i = 1; i <= n / i; i ++){
            if (n % i == 0){
                list.add((long) i);
                if (i != n / i)
                    list.add( n / i);
            }
        }
    }

    public static void main(String[] args) {
        get_factor();
        int cnt = list.size();
        int res = 0;
        for (int l = 0; l < cnt; l ++)
            for (int w = 0; w < cnt; w ++)
                for (Long aLong : list) {
                    if ((long) list.get(l) * list.get(w) * aLong == n) {
                        res++;
                    }
                }
        System.out.println(res);
//        System.out.println(2430);
    }

}
