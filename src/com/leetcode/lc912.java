package com.leetcode;

import java.util.Arrays;

public class lc912 {

    public static int n;
    public static int first, last;

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int x = nums[(int) (Math.random() * (r - l + 1)) + l];
        partition(nums, l, r, x);
        int left = first, right = last;
        quickSort(nums, l, left - 1);
        quickSort(nums, right + 1, r);
    }

    public static void partition(int[] nums, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (nums[i] > x) {
                swap(nums, i++, first++);
            } else if (nums[i] == x) {
                i++;
            } else {
                swap(nums, last--, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        lc912 test = new lc912();
        System.out.println(Arrays.toString(test.sortArray(nums)));
    }

}


