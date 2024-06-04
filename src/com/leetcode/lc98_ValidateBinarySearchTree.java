package com.leetcode;

class lc98_ValidateBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static long min, max;

    public boolean isValidBST(TreeNode root) {
        // 1. 如果root为空，则赋值min，max反差的同时，返回true
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        // 2. 然后看下左子树是不是二叉搜索树，同时将全局变量的值更新到局部变量里
        boolean l = isValidBST(root.left);
        long lmin = min;
        long lmax = max;
        // 3. 右子树也是一样的操作
        boolean r = isValidBST(root.right);
        long rmin = min;
        long rmax = max;
        // 4. 然后三个值同一比较，得知min和max
        min = Math.min(Math.min(lmin, rmin), root.val);
        max = Math.max(Math.max(lmax, rmax), root.val);
        // 5. 返回 符合二叉搜索树的布尔值（左得是，右得是，且左最大值<root.val<右最小值）
        return l && r && lmax < root.val && root.val < rmin;
    }
}
