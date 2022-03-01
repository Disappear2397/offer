package com.leetcode.搜索与回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/18 11:06
 */
public class 剑指32打印二叉树1{
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public static int[] levelOrder(TreeNode root) {
    if(root == null) return new int[0];
    Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
    ArrayList<Integer> ans = new ArrayList<>();
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      ans.add(node.val);
      if(node.left != null) queue.add(node.left);
      if(node.right != null) queue.add(node.right);
    }
    int[] res = new int[ans.size()];
    for(int i = 0; i < ans.size(); i++)
      res[i] = ans.get(i);
    return res;
  }


  public static void main(String[] args) {
    TreeNode a = new TreeNode(2);
    a.left = new TreeNode(4);
    a.right = new TreeNode(6);
    a.left.left = new TreeNode(7);
    a.left.right = new TreeNode(9);
    a.right.right = new TreeNode(21);
    a.right.left = new TreeNode(14);
    int[] list = levelOrder(a);
    System.out.println(Arrays.toString(list));
  }
}
