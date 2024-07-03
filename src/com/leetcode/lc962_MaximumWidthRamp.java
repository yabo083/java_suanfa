package com.leetcode;

/**
 * 题意理解：<br />
 * 不好理解，<br />
 * 因为我不懂为什么摘出一部分数到降序的单调栈里，<br />
 * 然后再倒序遍历一遍数组，寻找符合关系的数对，<br />
 * 满足了就弹出，不满足就右进。<br />
 * 这样就能找到最大的宽度？？<br />
 * <hr>
 * 升序单调栈无意义，因为这样后面全和栈底构成坡得了，<br />
 * 不如降序！等于也不行！<br />
 * 所以就此，按降序收集所有下标。<br />
 * <hr>
 * 当匹配到一个数对，计算出答案后，<br />
 * 选择弹栈，目的是让以后的答案以这个为标准，至少也得是这个值，<br />
 * 必须更大！<br />
 * 还能防止答案劣化。<br />
 *
 * @author Yabo
 * @date 2024/07/03
 */
class lc962_MaximumWidthRamp {

    public static int MAXN = 50001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public int maxWidthRamp(int[] nums) {
        // 1. 自动入栈数组[0]
        r = 1;
        // 2. 获取数组长度n
        int n = nums.length;
        // 3. for循环，降序单调栈，只有比栈顶严格小于的值的下标才被允许入栈
        for (int i = 1; i < n; i++) {
            if (nums[stack[r - 1]] > nums[i]) {
                stack[r++] = i;
            }
        }
        // 4. 创建答案变量
        int ans = 0;
        // 5. for循环，逆序遍历，满足坡的条件，弹栈并计算一次答案；不满足则右进。
        for (int j = n - 1; j >= 0; j--) {
            while (r > 0 && nums[stack[r - 1]] <= nums[j]) {
                ans = Math.max(ans, j - stack[--r]);
            }
        }
        // 6. 返回答案。
        return ans;
    }
}
