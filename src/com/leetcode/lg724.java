package com.leetcode;

import java.util.Arrays;

public class lg724 {


    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftsum = 0;
        for(int i = 0; i < nums.length; ++ i)
        {
            if(2 * leftsum + nums[i] == total)
                return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
