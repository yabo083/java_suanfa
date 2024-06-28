package com.leetcode;

/**
 * 题意比喻：<br />
 * 你是公司任命的经理，公司要求让k个人去解决总量为nums的任务，<br />
 * 你需要给每个人分配恰当的工作量，使每个人的工时最短，<br />
 * 因为根据劳动法规定，一个人干的越多，挣的钱就成指数倍数增长！<br />
 * 为了公司的利益，你不能让每个人干太多，所以，把极大值压下来！<br />
 * 这个任务就看你的了！<br />
 * <hr>
 * 1. 欲求：极大值的最小值——一个点<br />
 * 2. 扩展：[0, 所有工作总和]——一个范围<br />
 * 单调性：工时的极大值越大，人数越少<br />
 * 3. 判断：当前的工时需要的人少于k吗？<br />
 * 少了？糟糕！成本大了！需要降低工时！顺带记录在达到平衡之前，最低工时能有多低？这就是答案！<br />
 * 多了？糟糕！人手不够！需要提高工时！<br />
 * <hr>
 * 4. f函数：当前工时需要多少人？<br />
 * 算法：遍历工作列表，在未超过当前工时的限制时，个人总工时可以尽情累加，<br />
 * 一旦超过，则需要人数++，同时个人总工时需要从让其越界的那个工作上再次开始！<br />
 * 最后返回需要人数。<br />
 *
 * @author Yabo
 * @date 2024/06/28
 */
class lc410_SplitArrayLargestSum {

    public static int f(int[] arr, long limit) {
        // 1. 初始化个人总工时和需要人数(怎么想，还真就需要1个人啊，题设也能佐证！)
        int sum = 0, cnt = 1;
        // 2. for循环，遍历、累加、超限则重新累加、计数
        for (int i : arr) {
            if (i > limit) {
                return Integer.MAX_VALUE;
            }
            if (sum + i > limit) {
                cnt++;
                sum = i;
            } else {
                sum += i;
            }
        }
        // 3. 返回答案
        return cnt;
    }

    public int splitArray(int[] nums, int k) {
        // 1. 求值：区间右端点
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 2. for循环：二分主要流程简述：
        //     1. 初始化左右端点，试行工时mid
        //     2. 开始二分
        int ans = 0;
        for (int l = 0, r = sum, mid = 0; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (f(nums, mid) <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 3. 返回答案
        return ans;
    }
}
