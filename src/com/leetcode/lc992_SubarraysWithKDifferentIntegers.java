package com.leetcode;

import java.util.Arrays;

/**
 * 题义理解：
 * <br>
 * sb题目，说的明明是数字种类不同且等于k，非要说个数！
 * <hr>
 * 解题关键在于将nums严格=k的数组，转换为求<=k的数组，然后和<=(k-1)作差
 * <hr>
 * 问题：窗口长度竟能直接等于其衍生子数组个数？
 * 答：确实，虽然不是一次找齐，而是按规律，找的是以r结尾的全部子数组，但综合起来恰恰能找齐一个窗口对应的全部子数组！
 *
 * @author Yabo
 * @date 2024/06/26
 */
class lc992_SubarraysWithKDifferentIntegers {

    public static int[] cnts = new int[20001];

    public static int numsOfMostKinds(int[] arr, int k) {
        // 1. 将用到的长度范围初始化为0
        Arrays.fill(cnts, 0, arr.length + 1, 0);
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环，流程概解：
        //     1. 以r为先锋，凡新元素，皆收归帐下，种类变量++
        //     2. 如收集元素种类（mc背包满了）大于k，则需从左端点弃，
        //     弃时，也同步减少
        //     3. 将此时子数组个数累加至答案变量中
        for (int l = 0, r = 0, kinds = 0; r < arr.length; r++) {
            if (++cnts[arr[r]] == 1) {
                kinds++;
            }
            while (kinds > k) {
                if (--cnts[arr[l++]] == 0) {
                    kinds--;
                }
            }
            ans += r - l + 1;
        }
        // 4. 输出答案变量即可
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // 1. 作差
        return numsOfMostKinds(nums, k) - numsOfMostKinds(nums, k - 1);
    }


}
