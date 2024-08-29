package com.leetcode;

/**
 * tmd对于要满足的公式的转换真是太巧妙了！<br /> 找出 yi + yj + |xi - xj| 的 最大值<br /> 等于找xj+yj+yi-xi的最大！<br /> 而xj+yj对于具体讨论每种情况来说又是固定的，<br
 * /> 所以就等同于找yi-xi的最大！<br /> 把这个值用单调队列保持，时刻能拿一个最大值<br />
 *
 * @author Yabo
 * @date 2024/08/28
 */
class lc1499_MaxValueOfEquation {

    public static int MAXN = 100001;

    // [、i号点[x,y]、]
    //  h、t
    public static int[][] deque = new int[MAXN][2];

    public static int h, t;

    public int findMaxValueOfEquation(int[][] points, int k) {
        // 1. 初始化单调队列结构参数
        h = t = 0;
        // 2. 获取点数组的长度
        int n = points.length;
        // 3. 设置答案变量
        int ans = Integer.MIN_VALUE;
        // 4. for循环，结束后可获取ans
        for (int i = 0, x, y; i < n; i++) {
            //     1. 范围是要遍历所有点，所以是[0,n]
            //     2. 拿出此刻点[x,y]
            x = points[i][0];
            y = points[i][1];
            //     3. 在队列有点的情况下，根据限制连续去除头点
            while (h != t && x > k + deque[h][0]) {
                h++;
            }
            //     4. 上步结束后，如果队列仍有点，则可计算一次答案。
            if (h < t) {
                ans = Math.max(ans, x + y + deque[h][1] - deque[h][0]);
            }
            //     5. while循环，单调队列更新期
            while (h != t && deque[t - 1][1] - deque[t - 1][0] <= y - x) {
                t--;
            }
            deque[t][0] = x;
            deque[t++][1] = y;
        }
        // 5. 返回答案
        return ans;

    }
}
