package com.leetcode;

class lc222_CountCompleteTreeNodes {

    public static int f(TreeNode cur, int level, int h) {
        // 1. 如果当前节点的深度等于整颗树的深度，那就返回1喽
        if (level == h) {
            return 1;
        }
        // 2. 如果当前节点的右子树的最左节点能到最深层，那就可直接返回左子树的节总数+当前节点的一个计数+以右子节点为根的子树节点个数
        if (mostLeft(cur.right, level + 1) == h) {
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        } else {
            // 3. 如果当前节点的右子树的最左节点没能到最深层，那就可直接返回右子树的总节点树+当前节点的一个计数+以左子节点为根的子树节点个数
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    public static int mostLeft(TreeNode cur, int level) {
        // 求的是以当前节点为根的完全二叉子树的深度
        // 1. 只要不断遍历就好
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level -1 ;
    }

    public int countNodes(TreeNode root) {
        // 1. 如果root为空，那当然是0
        if (root == null) {
            return 0;
        }
        // 2. 返回自定义函数的值啦
        return f(root, 1, mostLeft(root, 1));
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }
}
