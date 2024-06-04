package com.leetcode;

class lc337_HouseRobberIII {

    // 全局变量，完成了X子树的遍历，返回之后
    // yes变成，X子树在偷头节点的情况下，最大的收益
    public static int yes;
    // 全局变量，完成了X子树的遍历，返回之后
    // no变成，X子树在不偷头节点的情况下，最大的收益
    public static int no;

    public static void f(TreeNode root) {
        // 1. 如果为空，那yes和no都为0
        if (root == null) {
            yes = 0;
            no = 0;
        } else {
            // 2. 不为空的话，先局部变量y存下当前节点值，n不存为0
            int y = root.val;
            int n = 0;
            // 3. 递归调用，这次是左节点
            f(root.left);
            // 4. y由于规则所限，只能加no
            y += no;
            // 5. n的话，取最大就行
            n += Math.max(yes, no);
            // 6. 再次递归调用，右节点
            f(root.right);
            // 7. 重复4、5步
            y += no;
            n += Math.max(yes, no);
            // 8. 刷新全局变量
            yes = y;
            no = n;
        }
    }

    public int rob(TreeNode root) {
        // 1. 调用子函数
        f(root);
        // 2. 返回最大值
        return Math.max(yes, no);
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }

}
