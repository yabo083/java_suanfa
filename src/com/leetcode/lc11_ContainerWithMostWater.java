package com.leetcode;

/**
 * 题意理解：
 * <br>
 * 这里的垂线不占空间，只起阻挡作用
 * <hr>
 * 容器容量只与受“木桶效应”制约的两边垂线和底部宽度决定
 * <br>
 * 而根据三叶姐的分析，只有“将高度小的指针往内移动，才会枚举到更大的面积！”
 * <br>
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        // 1. 初始化答案变量
        int ans = 0;
        // 2. for循环，流程简述：
        for (int l = 0, r = height.length - 1; l < r; ) {
            //     1. 两个指针分居左右，互相靠拢
            //     2. 每次先算有无更大的容量，有就更新
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            //     3. 两个指针所指示的垂线，哪个低更新那边
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        // 3. 返回答案
        return ans;
    }
}
