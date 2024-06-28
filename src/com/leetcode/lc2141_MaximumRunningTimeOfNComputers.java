package com.leetcode;

import java.util.PriorityQueue;

/**
 * 题意理解：<br />
 * 大电池：在当前时间限制下，可一直给一台电脑供能<br />
 * 小电池：在当前时间限制下，需要与其他小电池搭配才能供能指定时间<br />
 * <hr>
 * 1. 欲求：同时运行的最长分钟数——一个点<br />
 * 2. 扩展：[1, 电能总和]——注意这是运行时间的范围！<br />
 * 单调性：电能越多，同时运行的分钟数也就越多？<br />
 * 3. 判断：所有电池，能不能让所有电脑运行mid分钟？<br />
 * 能？试试更大能不能？史官记这个！<br />
 * 不能？遗憾降低要求！<br />
 * <hr>
 * 4. f函数：所有电池，能不能让所有电脑运行mid分钟？<br />
 * 算法：遍历所有电池，一个大电池单独供能mid分钟，<br />
 * 统计剩下的小电池，如果能量总和哪轮大于等于了所有电脑运行mid分钟所需<br />
 * 则直接返回true，<br />
 * 如果遍历完，那请返回false！<br />

 *
 * @author Yabo
 * @date 2024/06/28
 */
class lc2141_MaximumRunningTimeOfNComputers {

    public static boolean f(int[] batteries, int n, int time) {
        // 1. for循环，流程简述：
        //     1. 如果是能量大于等于time，则视为大电池
        //     2. 如果是能量小于time，视为小电池，累加至能量总和
        //     3. 每轮判断，能量总和是否>=所有电脑运行mid分钟所需，
        //     如是，则直接返回true，
        long sum = 0;
        for (int battery : batteries) {
            if (battery >= time) {
                n--;
            } else {
                sum += battery;
            }
            if (sum >= (long) time * n) {
                return true;
            }
        }
        // 4. 来到这里说明情况不容乐观，返回false。
        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
        // 1. 优化：寻找能量最多的电池，
        // 随后若所有电池能量总和大于等于以max为标准运行的所有电脑所需，
        // 则直接可返回 sum/num
        int max = 0;
        long sum = 0;
        for (int battery : batteries) {
            max = Math.max(max, battery);
            sum += battery;
        }
        if (sum >= (long) max * n) {
            return sum / n;
        }
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环，二分流程简述：
        //     1. 初始化两端点，
        //     2. 开始二分
        for (int l = 0, r = max, mid; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (f(batteries, n, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 4. 返回答案
        return ans;
    }






}
