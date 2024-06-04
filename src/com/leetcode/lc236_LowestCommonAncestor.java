package com.leetcode;

class lc236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 先考虑特殊情况：遇到空、p、q，就直接返回
        if (root == null || root == p || root == q) {
            return root;
        }
        // 2. 不是以上情况的话，就往下遍历，先左后右
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        // 5. 如果都找到了，那就返回此时的节点
        if (l != null && r != null) {
            return root;
        }
        // 3. 如果没有就返回空吧
        if (l == null && r == null) {
            return null;
        }
        // 4. 如果只找到一个，那就返回那一个
        return l == null ? r : l;

    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }
}
