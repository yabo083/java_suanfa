package com.tools;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <a href="https://www.cnblogs.com/guojuboke/p/10369200.html">原文章</a>
 * 建议只当模版写就行，如果调用方法似乎会因为java的值传递，而导致实质上没有交换。
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

     // Collections.swap()和Arrays.swap()都是值传递，不会改变原始值
    public static void swap4(int a, int b) {
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(10000, 0));
        System.out.println("原始值：" + a + "," + b);
        Collections.swap(list, 0, 1);
        System.out.println("交换后：" + a + "," + b);

    }

    public static void main(String[] args) {
        swap3(3, 5);
        System.out.println(System.getProperty("file.encoding"));
    }

}
