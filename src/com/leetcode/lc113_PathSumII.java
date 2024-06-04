package com.leetcode;

import java.util.ArrayList;
import java.util.List;

class lc113_PathSumII {

    public static void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {
        // 1. 如果是叶节点（即左右子节点都为空），那就如果等于目标值，则记录这条路径（我觉得可以用clone），随后删除
        if (cur.left == null && cur.right == null) {
            if (cur.val + sum == aim) {
                path.add(cur.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            // 2. 如果不是叶节点，那先把当前节点记录，然后继续向下看看，左不为空，就向左看；右不为空就向右看；
            path.add(cur.val);
            if (cur.left != null) {
                f(cur.left, aim, sum + cur.val, path, ans);
            }
            if (cur.right != null) {
                f(cur.right, aim, sum + cur.val, path, ans);
            }
            // 3. 删除当前节点
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 1. 创建答案List
        List<List<Integer>> ans = new ArrayList<>();
        // 2. 如果root不为空，那么开始吧！
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            f(root, targetSum, 0, path, ans);
        }
        // 3. 返回
        return ans;
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }
}
