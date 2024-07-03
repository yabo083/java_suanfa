package com.leetcode;

/**
 * 题意理解：<br />
 * <hr>
 * 使用单调栈可以批量计算子数组最小值的和<br />
 * <hr>
 * 但我对为什么这样能找全所有子数组心存疑虑。<br />
 * （虽然已经验证过一个例子了）<br />
 * <hr>
 * 关于重复值的问题，当两个相同值可以互相包含地而计算子数组时，<br />
 * 必然会重复，所以不如让在前的重复值遇到后一个重复值时停止，<br />
 * 把包含所有重复值的子数组的计算任务交给最后一个重复值得了。<br />
 *
 * @author Yabo
 * @date 2024/07/02
 */
class lc907_SumOfSubarrayMinimums {

    public static int MOD = (int) 1e9 + 7;

    public static int MAXN = 30001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public int sumSubarrayMins(int[] arr) {
        // 1. 创建答案变量
        long ans = 0;
        // 2. 初始化栈顶指针
        r = 0;
        // 3. for循环，单调栈遍历流程：
        //     1. 采用升序单调栈，仍然是只记录下标，
        //     2. 每次有不合规矩的值出现，就说明又有一个极小值出现，
        //     可以更新一次答案。
        //     具体：看看证明出的极小值可以扩展出几个子数组，
        //     随后一起累加，与旧值累加
        for (int i = 0, top; i < arr.length; i++) {
            while (r > 0 && arr[i] <= arr[stack[r - 1]]) {
                top = stack[--r];
                int l = r == 0 ? -1 : stack[r - 1];
                ans += (long) (top - l) * (i - top) * arr[top] % MOD;
            }
            stack[r++] = i;
        }
        // 4. while循环，处理栈中残余：
        //     也是和for循环里一样的计算步骤
        while (r > 0) {
            int top = stack[--r];
            int l = r == 0 ? -1 : stack[r - 1];
            ans += (long) (top - l) * (arr.length - top) * arr[top] % MOD;
        }
        // 5. 返回答案
        return (int) (ans % MOD);
    }
}
