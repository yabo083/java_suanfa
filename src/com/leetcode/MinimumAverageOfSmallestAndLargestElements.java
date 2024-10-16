package com.leetcode;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {

    public static double minimumAverage(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        double averages = Integer.MAX_VALUE;
        for (int i = 0, j = n - 1, minE, maxE; i < j; ) {
            minE = nums[i++];
            maxE = nums[j--];
            averages = Math.min(averages, (double) (minE + maxE) / 2);
        }
        return averages;
    }

    public static void main(String[] args) {
        System.out.println(minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
        System.out.println(minimumAverage(new int[]{1,9,8,3,10,5}));
        System.out.println(minimumAverage(new int[]{1,2,3,7,8,9}));
    }

}
