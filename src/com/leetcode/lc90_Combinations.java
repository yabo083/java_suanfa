package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class lc90_Combinations {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 1. 初始化答案数组
        List<List<Integer>> ans = new ArrayList<>();
        // 2. 先给数组排序（目的是使其自然分组）
        Arrays.sort(nums);
        // 3. 调用递归子函数
        f(nums, 0, new int[nums.length], 0, ans);
        // 4. 返回答案
        return ans;
    }

    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        // 1. 如果i等于了数组的长度，说明已经找到一个组合，结合size将其添加至新创建的数组中，随后在加入答案数组中
        if (i == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < size; j ++){
                tmp.add(path[j]);
            }
            ans.add(tmp);
        } else {
            // 2. 如果没有，那就先获取下一组数的第一个数的位置，随后以当前数选0个的选择，递归；随后在for循环中，依次选1、2、3……个，再递归调用。
            int j = i;
            while ( j < nums.length && nums[j] == nums[i]){
                j ++;
            }
            f(nums, j, path, size, ans);
            for (;i < j; i ++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }
    }
}
