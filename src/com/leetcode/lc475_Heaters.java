package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * <br>
 * 你只需权衡每家需要的最小半径，
 * <br>
 * 随后再取个最大，就能满足所有人的需要了。
 * <hr>
 * 找“最大公约数”，找到大家都能接受的尺度
 * <hr>
 * 数组每个值的意思：是房屋或供暖器的位置，可以想象它们排列在一条数轴上。
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc475_Heaters {

    public static boolean best(int[] houses, int[] heaters, int i, int j) {
        // 1. 返回是否是最短的半径：
        //     1. 如果已经到达最后一个边界，那捏着鼻子也得认！返回true
        //     2. 如果后一个供暖器离得更近或者和当前的一样，那并非最短，返回false
        return j == heaters.length - 1 || Math.abs(houses[i] - heaters[j]) < Math.abs(houses[i] - heaters[j + 1]);
    }

    public int findRadius(int[] houses, int[] heaters) {
        // 1. 先给两个数组排个序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环，流程简述：
        for (int i = 0, j = 0; i < houses.length && j < heaters.length; i++) {
            //     1. 找到第i家需要的最小半径,不管他是和哪个供暖器配对，
            //     如果第j个供暖器不行，那就换下一个
            while (!best(houses, heaters, i, j)) {
                j++;
            }
            //     2. 找到啦？那你来登记一下，我们将会综合大家的情况调整供暖器有效范围的！
            ans = Math.max(ans, Math.abs(houses[i] - heaters[j]));
        }
        // 4. 返回答案
        return ans;
    }


}
