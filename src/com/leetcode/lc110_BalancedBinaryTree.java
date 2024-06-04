package com.leetcode;

class lc110_BalancedBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public static boolean balance;
    public boolean isBalanced(TreeNode root) {
        // 1. 先假定指示器是平衡的
        balance = true;
        // 2. 随后调子函数
        height(root);
        // 3. 返回指示器
        return balance;
    }

    public static int height(TreeNode cur) {
        // 1. 如果指示器指示不平衡或cur为空，返回0
        if (!balance || cur == null) {
            return 0;
        }
        // 2. 计算左右节点的高度
        int lh = height(cur.left);
        int rh = height(cur.right);
        // 3. 如果左右节点的高度差大于1，指示器立马红灯
        if (Math.abs(lh - rh) > 1){
            balance = false;
        }
        // 4. 无论如何，返回极大值+1的结果
        return Math.max(lh, rh) + 1;
    }
}
