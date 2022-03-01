package com.leetcode.搜索与回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/25 10:39
 */
public class 剑指32打印二叉树层次遍历广度优先2{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
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
        List<List<Integer>> list = levelOrder(a);
        System.out.println(list);
    }
}
