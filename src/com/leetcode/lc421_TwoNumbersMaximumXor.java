package com.leetcode;

class lc421_TwoNumbersMaximumXor {

    // 准备这么多静态空间就够了，实验出来的
    // 如果测试数据升级了规模，就改大这个值
    public static int MAXN = 3000001;
    public static int[][] tree = new int[MAXN][2];
    // 前缀树目前使用了多少空间
    public static int cnt;
    // 数字只需要从哪一位开始考虑
    public static int high;

    public static void build(int[] nums) {
        // 1. 初始化new指针
        cnt = 1;
        // 2. 找到最大值
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 3. 计算基准
        high = 31 - Integer.numberOfLeadingZeros(max);
        // 4. 开始逐个插入
        for (int num : nums) {
            insert(num);
        }
    }

    public static void insert(int num) {
        // 1. 试试默写？
        int cur = 1;
        for (int i = high; i >= 0; i--) {
            int path = (num >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
        // 2. 只给一个提示：如何从基准位向最右边依次取值？
    }

    public static int maxXor(int num) {
        // 1. 初始化答案寄存器
        int ans = 0;
        // 2. 初始化临时节点指针
        int cur = 1;
        // 3. for 循环，循环处理形参的每个二进制位，需要确定每一位的实际状态，欲求最大的期望状态，随后以将期望投入前缀树，如果为0，则代表没办法，利用异或反转，
        // （这里的0和1的存在，确实是非此即彼的关系，所以可以自信地这路不行走那路）。
        // 无论如何将期望与实际异或值右移当前当前讨论位，插进答案寄存器中，最后临时节点指针向下一个节点迈进。
        for (int i = high, curStatus, hopeStatus; i >= 0; i--) {
            curStatus = (num >> i) & 1;
            hopeStatus = curStatus ^ 1;
            if (tree[cur][hopeStatus] == 0) {
                hopeStatus ^= 1;
            }
            ans |= (hopeStatus ^ curStatus) << i;
            cur = tree[cur][hopeStatus];
        }
        // 4. 返回答案寄存器
        return ans;
    }

    public static void clear() {
        // 1. 还是那样简单
        for (int i = 0; i < cnt; i++) {
            tree[i][0] = tree[i][1] = 0;
        }
    }

    public int findMaximumXOR(int[] nums) {
        // 1. 构造前缀树，把数组里的每个数都扔进去，（存的是以最大值为基准的二进制数，全是01）
        build(nums);
        // 2. 初始化答案寄存器
        int ans = Integer.MIN_VALUE;
        // 3. for 循环，循环调用子函数，得到最大异或值
        for (int num : nums) {
            ans = Math.max(ans, maxXor(num));
        }
        // 4. 清理
        clear();
        // 5. 返回答案寄存器
        return ans;
    }

}
