package com.leetcode;

import com.leetcode.搜索与回溯算法.剑指32打印二叉树1;

import java.util.Arrays;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/23 10:33
 */
public class 二叉树中的最大路径和{
    //求从任意节点开始的最大路径和
    public static class TreeNode {
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
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    // 返回经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftMax = Math.max(0, dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0, dfs(root.right));
        //left->root->right 作为路径与已经计算过历史最大值做比较，节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        max = Math.max(max, root.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用,给dfs(root.left)和dfs(root.right)计算使用
        return root.val + Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(4);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(7);
        a.left.right = new TreeNode(9);
        a.right.right = new TreeNode(21);
        a.right.left = new TreeNode(14);
        System.out.println(maxPathSum(a));
    }

}
