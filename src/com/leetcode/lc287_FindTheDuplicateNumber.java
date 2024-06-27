package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * <br>
 * n+1长度，却被只允许存在[1,n]的值，当然会有重复！
 * <hr>
 * 可变换视角，将题目视作查找第一个入环节点的题目.
 * <br>
 * 将数组值视作数组的下标，这就有了指针移动的可能性。
 * <hr>
 * 再者，初闻此题时，通过代码也知道了流程：
 * <br>
 * 快慢指针先一快一慢，直到第一次相遇，
 * <br>
 * 随后快指针回开头，以慢指针的速度重走，
 * <br>
 * 再次相遇时，即是入环节点，也即这道题的重复整数。
 * <hr>
 *
 * （怎么听起来不直观？……想想就懂了，不直观可以举几个例子，
 * <br>
 * 这次我还是可以说服自己相信的。
 * <hr>
 * 比较不优雅的做法：
 * <br>
 * 每个数依次和其他数异或，
 * <br>
 * 如果哪次为0，即是重复数。
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // 0. 特判：如果数组为空，或数组长度不足2个数，请直接返回-1（？？题目也没说啊
        if (nums == null || nums.length < 2) {
            return -1;
        }
        // 1. 创建快慢指针
        int f = nums[nums[0]];
        int s = nums[0];
        // 2. while循环，两指针不等时一直走
        while (f != s) {
            f = nums[nums[f]];
            s = nums[s];
        }
        // 3. while循环退出才来到这里，说明此时已经相遇，则将快指针归0
        f = 0;
        // 4. 速度同步，不等时一直走
        while (f != s) {
            f = nums[f];
            s = nums[s];
        }
        // 5. 最后返回任意一个指针。
        return f;
    }

    /**
     * 每项异或能行，但会超时.
     * 下面的这种别人的异或确实可行，不过从时间效率上图一乐。
     *
     *
     * @param nums NUMS
     * @return int
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
            if (a == 0) {
                return nums[i];
            } else {
                a = nums[i];
            }
        }
        return -1;
    }
}
