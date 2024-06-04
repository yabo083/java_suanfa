package com.leetcode;

class lc669_TrimBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 1. 如果root为空，那就返回空
        if (root == null) {
            return null;
        }
        // 2. 如果root值小于区间左端点，那就去右
        if (root.val < low){
            return trimBST(root.right, low, high);
        }
        // 3. 如果root值大于区间右端点，那就去左
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        // 4. 如果在范围中，那就重新赋值root左、右
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        // 5. 最后返回领衔节点
        return root;
    }
}
