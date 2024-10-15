package com.leetcode;

public class lc3200_MaximumHeightOfATriangle {

    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxH(red, blue), maxH(blue, red));
    }

    private static int maxH(int top, int other) {
        int x = 1;
        int countH = 0;
        while (top >= 0 && other >= 0) {
            if (top - x < 0) {
                break;
            }
            top -= x;
            countH++;
            x++;
            if (other - x < 0) {
                break;
            }
            other -= x;
            countH++;
            x++;
        }
        return countH;
    }

    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(2, 4));
    }
}
