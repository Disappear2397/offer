package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/24 19:38
 */
public class 二叉树的路径总和{
    //求树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
    //路径总和2 与剑指34二叉树和为某一值的路径一模一样
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
