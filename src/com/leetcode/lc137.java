package com.leetcode;

import java.util.Arrays;

public class lc137 {

    public static int[] cnts = new int[32];
    public static int singleNumber(int[] nums) {

        return find(nums, 3);
    }

    public static int find(int[] nums, int m){
        Arrays.fill(cnts, 0);
        for (int num : nums){
            int j = 31;
            if (num > 0){
            while (num > 0){
                cnts[j --] += num & 1;
                num >>= 1;
            }
            }else {
                for (int i = 0; i < 32; i++){
                    cnts[31 - i] += (num >> i) & 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i ++){
            if ((cnts[31 - i] % m) != 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }

}
