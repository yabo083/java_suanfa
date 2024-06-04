package com.self;

public class TowerOfHanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "A", "C", "B");
        }
    }

    public static void f(int i, String from, String to, String other) {
        // 1. 如果当前盘为1，那就将其从from移动到to
        if (i == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            // 2. 如果不是盘1，那就先把盘1上面的所有盘从from 移动到 other，先暂存一下
            f(i - 1, from, other, to);
            // 3. 然后移动盘1,从from到to
            System.out.println("Move " + i + " from " + from + " to " + to);
            // 4. 最后将之前的所有暂存盘从other移动到to
            f(i - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
