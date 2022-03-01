package com.leetcode.搜索与回溯算法;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/4 21:42
 */
public class 剑指68二叉搜索树的最近公共祖先{
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(3);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(2);
        a.left.right = new TreeNode(4);
        a.left.left.left = new TreeNode(1);
        System.out.println(lowestCommonAncestor(a, a.right, a.left.right).val);
    }
}
