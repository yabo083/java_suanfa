package com.leetcode;

class lc235_LowestCommonAncestorBinarySearch {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 如果cur既不等于p、也不等于q，那就向下走
        while (root.val != p.val && root.val != q.val) {
            // 3. 如果恰好处于中间，那就直接返回
            if (Math.min(q.val, p.val) < root.val && root.val < Math.max(p.val, q.val)) {
                break;
            }
            // 2. 如果小于二者较小的一边，那就向右走；否则向左走
            root = Math.min(q.val, p.val) > root.val ? root.right : root.left;
        }
        return root;
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }
}
