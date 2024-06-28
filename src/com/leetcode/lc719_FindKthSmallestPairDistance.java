package com.leetcode;

import java.util.Arrays;

/**
 * LC719 求 k 最小对距离
 * 题意理解：<br />
 * 转化是巧妙的，不要被第k小蒙蔽双眼！<br />
 * <hr>
 * 1. 欲求： 第k小的数对距离——更本质：数对距离<br />
 * 2. 扩展： [0, max-min]<br />
 * 单调性：选做标准的距离越大，被笼的数对也就越多！<br />
 * 3. 判断： <=当前用作标准的数对距离的数对数量，小于k吗？<br />
 * 小了？增大设作标准的数对距离！<br />
 * 大了？减小设作标准的数对距离！记录这个时候的“标准”，但为什么？<br />
 * 因为答案只在数对数量>=k的分支，而且有可能mid不是真实值。<br />
 * <hr>
 * 4. f函数：<=当前用作标准的数对距离的数对数量，又有几个呢？<br />
 * 算法：（滑动窗口）l和r从0出发，l先不动，<br />
 * r处的数和l处的数的距离如果小于限制，<br />
 * r就继续前进，<br />
 * 如果在某处超出限制，<br />
 * 则计算、累加此时l和r所围成的窗口中的数对数量（出奇地很好算！）<br />
 * 最后返回答案！<br />

 * @author Yabo
 * @date 2024/06/28
 */
class lc719_FindKthSmallestPairDistance {

    public static int f(int[] arr, int limit) {
        // 1. 创建计数器
        int cnt = 0;
        // 2. for循环，流程简述：
        //     1. 初始化窗口左右端点
        //     2. while循环步进r
        //     3. 计算、累加数对数量
        for (int l = 0, r = 0; l < arr.length; l++) {
            while (r + 1 < arr.length && arr[r + 1] - arr[l] <= limit) {
                r++;
            }
            cnt += r - l;
        }
        // 3. 返回计数器
        return cnt;
    }

    public int smallestDistancePair(int[] nums, int k) {
        // 1. 排序（自然的想法
        Arrays.sort(nums);
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环，二分流程简述：
        //     1. 初始化二分左右端点，试作为标准的数对距离mid，
        //     2. 开始二分
        for (int l = 0, r = nums[nums.length - 1] - nums[0], mid; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (f(nums, mid) >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 4. 返回答案变量
        return ans;
    }

}
