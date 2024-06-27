package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * <br>
 * 这个最小的正整数是从N+集合里来的，从1开始，哪个原数组没有答案就是哪个！
 * <hr>
 * 老师的做法我能理解：
 * <br>
 * 比较强势地重新给数组的每个下标都安置下标+1的数，而这些数都来自原数组。
 * <br>
 * 安置、妥协、降低期望，最后l与r相遇时，缺失的那个正整数就是l+1。
 * <hr>
 * <p>
 * 着重对五种情况进行分析：
 * <br>
 * 1. 小于等于l？不要！
 * <br>
 * 2. 大于r的数？不要！刚开始r是等于数组长度，也就是就算是全是正整数，
 * <br>
 * 最大的那个也不会大于r！
 * <br>
 * 3. 一个在l和r范围内的数，但在它应该在的位置上已经出现了它？也不要！重复要什么要啊！
 * <br>
 * 4. 一个数，正好是下标+1？好！要了
 * <br>
 * 5. 一个在l和r范围内的数，但在它应该在的位置上尚未出现它？那就把它换到它该在的位置！
 * <hr>
 * <p>
 * 不怎么优雅的做法：
 * <br>
 * 1. 排序
 * <br>
 * 2. 从正整数开始，将理想与现实对照，一旦不和，就返回那时的理想！
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc41_FirstMissingPositive {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        lc41_FirstMissingPositive lc41 = new lc41_FirstMissingPositive();
        int[] nums = {0, 2, 2, 1, 1};
        System.out.println(lc41.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        // 1. 初始化两个指针
        int l = 0, r = nums.length;
        // 2. while循环，流程简述：
        //     1. 五种情况，依次罗列
        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                swap(nums, l, --r);
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        // 3. 返回答案（就是l+1）
        return l + 1;
    }


    /**
     * 时间复杂度为O(nlogn)
     *
     * @param nums NUMS
     * @return int
     */
    public int firstMissingPositive2(int[] nums) {
        // 1. 先给数组排序
        Arrays.sort(nums);
        // 2. 初始化一个理想值
        int ideal = 1;
        // 3. for循环，流程简述：
        for (int num : nums) {
            if (num == ideal) {
                ideal++;
            }
        }
        // 4. 返回理想值
        return ideal;
    }


}
