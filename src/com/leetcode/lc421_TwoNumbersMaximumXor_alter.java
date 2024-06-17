package com.leetcode;

import java.util.HashSet;

class lc421_TwoNumbersMaximumXor_alter {

    public int findMaximumXOR(int[] nums) {
        // 0. 学习下怎么用hashset解题
        // 1. 还是先求最大值
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 2. 初始化答案寄存器
        int ans = 0;
        // 3. 初始化hashSet
        HashSet<Integer> set = new HashSet<>();
        // 4. for循环，起始值是之前求得的基准，就从这一位开始，手动构造最大异或值
        for (int i = 31 - Integer.numberOfLeadingZeros(max), want; i >= 0; i--) {
            // 5. 从基准开始，当然每一位最好是1啦。
            want = ans | (1 << i);
            // 6. 清空set（？……哦！每次存的都是保留位数不同的数，为了不干扰，当然要清空）（其实感觉越到后面越难凑来着，凑不到的自动就是0）
            set.clear();
            // 7. 遍历数组，将每个数先右移再左移，清掉i之后的状态，随后加入set。
            for (int num : nums) {
                num = (num >> i) << i;
                set.add(num);
                // 8. 判断set里是否存在期望与实际相异或后得到的值，有的话=期望成真！就能赋给答案寄存器了吧？随后跳出inner for结束这次循环
                if (set.contains(num ^ want)) {
                    ans = want;
                    break;
                }
            }
        }
        // 9. outer for结束后，返回答案寄存器的值
        return ans;
    }
}
