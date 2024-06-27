package com.leetcode;

/**
 * 题意理解：
 * <br>
 * 著名接雨水，不过是一维的幼年体，好做！
 * <hr>
 * 关键：以每个格子可存多少水为切入点，最后一累加
 * <br>
 * 而怎么知道呢？
 * <br>
 * 就得看两侧能有多高了！
 * <br>
 * 不分先后地找到左右的最高值，随后使用“短板效应”的手牌！
 * <br>
 * 确定了当前研究的格子储水高度，
 * <br>
 * 别忘了害得减去当前研究的格子本身的高度！
 * <hr>
 * 关于“找到左右的最高值”这件事，有两种做法：
 * <br>
 * 1. 预处理出来，
 * <br>
 * 2. 从边缘开始，边做边处理
 * <br>
 * （这里可能你会举出“反例”，但其实是你经验不足而已
 * 确实没问题。）
 * <hr>
 * 关于预处理的方法咱就不写了，毕竟这节主要练双指针！
 * <br>
 * 最后忠告：理解不了的地方建议加入物理模拟下就懂了。
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc42_TrappingRainWater {

    public int trap(int[] height) {
        // 1. 初始化一些值：两个指针，又两个指针，还有答案寄存器。
        int l = 1, r = height.length - 2, lmax = height[0], rmax = height[height.length - 1], ans = 0;
        // 2. while循环，流程简述：
        while (l <= r) {
            //     1. 如果lmax<=rmax,根据短板效应，l处能储多少水将由lmax决定，
            if (lmax <= rmax) {
                //     则按规则计算，累加至答案寄存器，lmax向右能更新就更新（当然是取较大的）
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l++]);
            } else {
                //     2. 剩下的情况遵循对称性，不多叙述，锻炼自己
                ans += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r--]);
            }
        }
        // 3. 返回答案变量
        return ans;
    }
}
