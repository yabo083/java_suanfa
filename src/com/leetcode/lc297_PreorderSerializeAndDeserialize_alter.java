package com.leetcode;

public class lc297_PreorderSerializeAndDeserialize_alter {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public static int cnt;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 1. 还是先准备builder
        StringBuilder sb = new StringBuilder();
        // 2. 进入主要的函数f，形参有root，和builder
        f(root, sb);
        // 3. 返回
        return sb.toString();
    }

    public void f(TreeNode root, StringBuilder sb) {
        // 1. 如果root是空的，直接来个占位符+逗号
        if (root == null)
            sb.append("#,");
        else
        // 2. 如果不为空，那就加上值+逗号，然后就是按照先序遍历的顺序，递归左右子树
        {
            sb.append(root.val).append(",");
            f(root.left, sb);
            f(root.right, sb);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1. 按逗号分割
        String[] strs = data.split(",");
        // 2. 进度计数（存储进度的变量是全局的）
        cnt = 0;
        // 3. 返回另一个子函数的结果
        return g(strs);
    }

    public TreeNode g(String[] vals) {
        // 1. 获取第一个字符
        String val = vals[cnt++];
        // 2. 如果是占位符的话，就返回空
        if (val.equals("#"))
            return null;
        else {
            // 3. 如果不是，就以此值新建节点，然后按照先序遍历的顺序赋值新节点的左右！最后返回此新节点！
            TreeNode head = new TreeNode(Integer.parseInt(val));
            head.left = g(vals);
            head.right = g(vals);
            return head;
        }
    }
}
