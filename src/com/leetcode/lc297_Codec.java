package com.leetcode;

public class lc297_Codec {

    // 这种手动建队列，遍历二叉树的方式值得学习！
    public static int MAXN = 10001;
    public static TreeNode[] q = new TreeNode[MAXN];
    public static int l, r;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 1. 既然是序列化，总得有个StringBuilder吧？
        StringBuilder sb = new StringBuilder();
        // 2. 常规一步：root不空才继续
        if (root != null) {
            // 3. l，r指针初始化，同时第一次序列化root，同时也把root入队
            l = r = 0;
            q[r++] = root;// tmd，怎么还能写成l++的？！
            sb.append(root.val).append(",");
            // 4. 开始队列不空就无法退出的while循环
            while (l < r) {
                // 5. 弹出元素的过程意外地只是弹出就好
                TreeNode t = q[l++];
                // 6. 如果左右子节点不为空，则在入队的同时，也序列化一下；为空就用占位符顶替一下嘛
                if (t.left != null) {
                    sb.append(t.left.val).append(",");
                    q[r++] = t.left;
                } else {
                    sb.append("#,");
                }
                if (t.right != null) {
                    sb.append(t.right.val).append(",");
                    q[r++] = t.right;
                } else {
                    sb.append("#,");
                }
            }
        }
        // 7. 最后返回成功，用toString方法啊！
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1. 特判：如果是个空字符串，直接返回空
        if (data.isEmpty()) {
            return null;
        }
        // 2. 先按逗号分割
        String[] arr = data.split(",");
        // 3. 新建一个局部变量，代表反序列化进程
        int cnt = 0;
        // 4. l，r初始化，同时root进队，同时头节点反序列化
        l = r = 0;
        TreeNode head = generate(arr[cnt++]);
        q[r++] = head;
        // 5. 又开始了，队列不空就无法结束的while循环
        while (l < r) {
            // 6. 出队
            TreeNode t = q[l++];
            // 7. 直接把节点的左右填满，无论是用空还是用实在的节点
            t.left = generate(arr[cnt++]);
            t.right = generate(arr[cnt++]);
            // 8. 啊，惯例的子节点入队
            if (t.left != null) {
                q[r++] = t.left;
            }
            if (t.right != null) {
                q[r++] = t.right;
            }
        }
        // 9. 返回头节点
        return head;
    }

    private TreeNode generate(String val) {
        // 1. 功能比较简单的：根据字符串的内容决定反序列化的出来的究竟是个什么？
        return val.equals("#") ? null : new TreeNode(Integer.parseInt(val));
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
}
