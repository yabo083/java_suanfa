package com.lanqiao;

import java.util.Scanner;


/**
 * <h3>蓝桥杯真题-时间显示（程序设计-20分）<h3/>
 * <a href="https://blog.csdn.net/AAAAA1235555/article/details/123242815">详情</a>
 */
public class lq1 {

    static long n, h, m, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
//        int n = (int) System.currentTimeMillis();
        n /= 1000;
        n %= 86400;
        h = n / 3600;
        n %= 3600;
        m = n/60;
        s = n%60;
        //这里爆红你认真的？懂了JDK版本问题，切成8就没事了
        System.out.printf("%02d:%02d:%02d",h,m,s);
    }


}
