package com.tools;

public class LowBits {


    public static int lowbit(int n){
        return n & (- n);
    }

    public static void main(String[] args) {
        System.out.println(lowbit(9));
    }

}
