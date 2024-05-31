package com.leetcode;

class lc958_CompletenessOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交以下的方法
    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 101;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public boolean isCompleteTree(TreeNode root) {
        // 1. 如果root是空，那按题目的意思就按是处理吧
        if (root == null)
            return true;
        // 2. l，r初始化，头节点入对
        l = r = 0;
        queue[r++] = root;
        // 3. 开始了——队列不空就无法结束的while循环
        boolean leaf = false;
        while (l < r) {
            // 4. 简简单单出个队！
            TreeNode h = queue[l++];
            // 5. 如果该节点的子节点情况是左空右有，那直接寄；另外如果叶子探针被激活，也要留意下接下来是否有不是叶子节点的情况，不是？也是直接寄
            if (h.left == null && h.right != null || leaf && h.left != null) {
                return false;
            }
            // 6. 无论左右，有就入队
            if (h.left !=null)
                queue[r++] = h.left;
            if (h.right != null)
                queue[r ++] = h.right;
            // 7. 叶子节点探针工作中
            if (h.left == null || h.right == null)
                leaf = true;
        }
        // 8. 如果能通过层层考验，那就返回true
        return true;
    }
}
