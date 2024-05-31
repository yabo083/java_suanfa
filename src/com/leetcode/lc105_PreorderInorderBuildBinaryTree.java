package com.leetcode;

import java.util.HashMap;

class lc105_PreorderInorderBuildBinaryTree {

  public static TreeNode f(
      int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> map) {
    // 1. 如果l1 > r1，直接返回空
    if (l1 > r1) {
      return null;
    }
    // 2. 好了，先建这一段的头节点head
    TreeNode head = new TreeNode(pre[l1]);
    // 3. 如果l1 等于 r1，说明此时就是叶子节点，直接返回该节点即可
    if (l1 == r1) {
      return head;
    }
    // 4. 接下来，先获取此时先序的头对应中序的位置
    int k = map.get(pre[l1]);
    // 5. 然后直接进行递归：
    //     head.left = f(自己琢磨)
    //     head.right = f(自己琢磨)
    head.left = f(pre, l1 + 1, l1 + k - l2, in, l2, k - 1, map);
    head.right = f(pre, l1 + k - l2 + 1, r1, in, k + 1, r2, map);
    // 6. 这才返回头！
    return head;
  }

  public static void main(String[] args) {}

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // 1. 特判：无论是前序数组为空，还是中序数组为空，亦或是两个数组长度不相等，
    //     都返回null；
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }
    // 2. 什么你嫌弃无法找到中序数组中的头节点？不妨试试map事先存好，事后直接调用
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    // 3. 好了，该把阵地转移到我们自己的函数了，注意有7个形参
    return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
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
