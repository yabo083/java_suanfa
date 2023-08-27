package com.tools;


/**
 * 原文章：<a href="https://www.cnblogs.com/guojuboke/p/10369200.html">...</a>
 */
public class Swap {

    public static void swap1(int a, int b) {
        System.out.println("原始值：" + a + "," + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("交换后：" + a + "," + b);
    }

    public static void swap2(int a, int b) {
//        int a = Integer.MAX_VALUE;
//        int b = Integer.MAX_VALUE - 1;
        System.out.println("原始值：" + a + "," + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("交换后：" + a + "," + b);
    }

    public static void swap3(int a, int b) {
        System.out.println("原始值：" + a + "," + b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("交换后：" + a + "," + b);
    }

    public static void main(String[] args) {
        swap3(3, 5);
        System.out.println(System.getProperty("file.encoding"));
    }

}
