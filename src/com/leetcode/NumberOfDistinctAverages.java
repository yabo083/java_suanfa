package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistinctAverages {

    public static int distinctAverages(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> averages = new HashSet<>();
        for (int i = 0, j = n - 1, minE, maxE; i < j; ) {
            minE = nums[i++];
            maxE = nums[j--];
//            averages.add((double) (minE + maxE) / 2);
            averages.add(minE + maxE); // 和的一半都不同了，和还能相同吗？

        }
        return averages.size();
    }

    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
        System.out.println(distinctAverages(new int[]{1, 100}));
    }

}
