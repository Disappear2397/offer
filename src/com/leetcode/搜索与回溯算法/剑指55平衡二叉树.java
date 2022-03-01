package com.leetcode.搜索与回溯算法;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/4 11:31
 */
public class 剑指55平衡二叉树{
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //自顶向下
    public static boolean isBalanced1(TreeNode root) {
        if(root == null)return true;
        else return Math.abs(high(root.left)-high(root.right))<=1 && isBalanced1(root.left) &&isBalanced1(root.right);
    }
    public static int high(TreeNode root){
        if (root == null) return 0;
        else return Math.max(high(root.left),high(root.right))+1;
    }

    //自低向上
    public static boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.left = new TreeNode(15);
        a.right.right = new TreeNode(7);
        System.out.println(isBalanced2(a));
    }
}
