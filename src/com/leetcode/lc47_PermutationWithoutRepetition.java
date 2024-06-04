package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class lc47_PermutationWithoutRepetition {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 1. 准备答案数组
        List<List<Integer>> ans = new ArrayList<>();
        // 2. 调用子函数
        f(nums, 0, ans);
        // 3. 返回答案数组
        return ans;
    }

    public static void f(int[] nums, int i, List<List<Integer>> ans) {
        // 1. 如果群星已经找到自己的位置，那就冻结时空，将一切盖棺定论
        if (i == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
        } else {
            // 2. 如果尚存变数，那就不吝变革，但要准备好回滚的手段，如果是复古派，那就不必上台了；务必是访问记录没有的才能交换
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j ++){
                if (set.add(nums[j])) {
                    swap(nums, i, j);
                    f(nums, i + 1, ans);
                    swap(nums, i, j);
                }
            }
        }
        // 3. 总之来说：一串数的全排列等于每个数当一次第一，再加上剩下数的全排列
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
