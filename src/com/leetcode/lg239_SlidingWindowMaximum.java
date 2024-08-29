package com.leetcode;

class lg239_SlidingWindowMaximum {

    public static int MAXN = 100001;

    // 数组模拟的双端队列
    public static int[] deque = new int[MAXN];

    // 首尾指针
    public static int h, t;

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. 先初始化赋0值给两个指针。
        h = t = 0;
        // 2. 用一个变量记录数组长度。
        int n = nums.length;
        // 3. for循环，k个数的窗口，但要先搞出一个k-1个数的窗口。
        for (int i = 0; i < k - 1; i++) {
            //     1. 总体循环次数设置为k-1即可
            //     2. 为了维持头大尾小的原则，简单的几个操作即可：
            //     while循环
            //         1. 如何有数且此时尾部之数<=即将被放之数，则尾指针退格、左移。
            //         2. 如果有数且此时尾部之数>即将被放之数，则什么也不做。
            while (h < t && nums[deque[t - 1]] <= nums[i]) {
                t--;
            }
            //     如果此时还没有数，那就右移尾指针放一个数的下标进来。
            deque[t++] = i;
        }
        // 4. 用一个变量记录从头到尾要计算的窗口数量。
        int m = n - k + 1;
        // 5. 用一个ans数组记录答案
        int[] ans = new int[m];
        // 6. for循环，遍历每个窗口，但初始化时l从0开始，r从k-1开始。
        for (int l = 0, r = k - 1; l < m; l ++, r ++ ) {
            //     1. while循环，单调数组规则维护期
            while(h < t && nums[deque[t - 1]] <= nums[r]){
                t --;
            }
            //     2. 单调数组扩张期
            deque[t ++] = r;
            //     3. 收集答案期
            ans[l] = nums[deque[h]];
            //     4. 此时就用到了上面的预设好的h和t。
            //     如果概念模型中的窗口的l和r的l等于了队列的h，则h++以示弹出旧数据。
            //     就是l马上就要指向下一个窗口，原先的最大值肯定不再适用，所以与l指向同一下标的h也得更新。
            //     如果不等，那就不处理。说明此时队头的最大值仍可沿用至下个窗口，甚至可能是下个窗口的最大值。
            if (deque[h] == l){
                h++;
            }
        }
        // 7. 返回ans数组。
        return ans;
    }
}
