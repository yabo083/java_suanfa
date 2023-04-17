package com.acwing.base;

import java.io.*;
import java.util.Scanner;


/**
 *数组模拟指针，idx初始化为1，e数组存值，ne数组存下一个节点的下标（索引）
 *用了ne数组的ne[0]为位置来当头节点（头指针），那么idx这个指针就不能再设为0，需要手动设下初值为1，
 * 而且还需在main函数里把ne[0]设为-1，职责迁移，但活没变，该初始化成什么样还是什么样。
 *最后一句话：涉及到‘指针’操作的，等号左边是变量，等号右边是值（看上去都是指针，但意义却不同呢）
 */
public class acwing826 {

    static int N = 100010;

    static int idx = 1;

    static int[] e = new int[N], ne = new int[N];

    static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }

    static void remove(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) throws IOException {
        Scanner bf = new Scanner(System.in);
        int m = bf.nextInt();
        ne[0] = -1;
        while (m -- > 0){
            int k, x;
            String op = bf.next();
            if ("H".equals(op)){
                x = bf.nextInt();
                add(0, x);
            }else if ("D".equals(op)){
                k = bf.nextInt();
                remove(k);
            }else {
                k = bf.nextInt();
                x = bf.nextInt();
                add(k, x);
            }

        }

        for (int i = ne[0]; i != -1; i = ne[i]){
            System.out.print(e[i] + " ");
        }
        System.out.println();


    }
}
