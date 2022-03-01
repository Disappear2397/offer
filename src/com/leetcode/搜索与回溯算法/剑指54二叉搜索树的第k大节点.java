package com.leetcode.搜索与回溯算法;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/3 14:47
 */
public class 剑指54二叉搜索树的第k大节点{

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static int res, k;
    public static int kthLargest(TreeNode root, int k) {
        剑指54二叉搜索树的第k大节点.k = k;
        dfs(root);
        return res;
    }
    static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(3);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(2);
        a.left.right = new TreeNode(4);
        a.left.left.left = new TreeNode(1);
        System.out.println(kthLargest(a,3));
    }


}
