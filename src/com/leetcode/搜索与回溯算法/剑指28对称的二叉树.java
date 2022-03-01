package com.leetcode.搜索与回溯算法;

import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/27 11:23
 */
public class 剑指28对称的二叉树{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
     static boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);
        a.right.right = new TreeNode(3);
        a.right.left = new TreeNode(4);
        System.out.println(isSymmetric(a));
    }
}
