package com.leetcode.搜索与回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/4 10:52
 */
     class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class 剑指55二叉树的深度{
         //深度优先 递归
    public static int maxDepth1(TreeNode root) {
            if(root == null) return 0;
            return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


     //层次遍历BFS
    public static int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        LinkedList<TreeNode> tmp = new LinkedList<>();
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
        public static void main(String[] args) {
           TreeNode a = new TreeNode(2);
            a.left = new TreeNode(4);
            a.right = new TreeNode(6);
            a.left.right = new TreeNode(9);
            a.right.right = new TreeNode(21);
            a.right.left = new TreeNode(14);
            System.out.println(maxDepth2(a));
        }
}
