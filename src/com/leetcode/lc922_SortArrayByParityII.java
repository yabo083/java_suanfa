package com.leetcode;

/**
 * 题意理解：
 * <br>
 * 感觉也没什么需要特意说的.
 * <br>
 * 就是奇数偶数不必按顺序.
 * <br>
 * 该是奇数的位置随便放个数组里的奇数就行.
 * <br>
 * 偶数也是这样。
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc922_SortArrayByParityII {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] sortArrayByParityII(int[] nums) {
        // 1. 获取数组长度
        int n = nums.length;
        // 2. for循环，初始化两个指针，一个指向奇数位置，一个指向偶数位置
        for (int even = 0, odd = 1; even < n && odd < n; ) {
            // 流程简述：
            //     1. 从末尾开始，如果是偶数，则与偶指针交换位置
            if ((nums[n - 1] & 1) == 1) {
                swap(nums, n - 1, odd);
                odd += 2;
            } else {
                //     反之则与奇指针交换位置。
                swap(nums, n - 1, even);
                even += 2;
            }
        }
        // 3. 返回原数组
        return nums;
    }

}
