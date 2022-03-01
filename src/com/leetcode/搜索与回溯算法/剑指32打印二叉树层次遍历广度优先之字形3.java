package com.leetcode.搜索与回溯算法;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/25 11:07
 */
//1.倒序 2.双端队列   这里用倒序 collections.reverse
public class 剑指32打印二叉树层次遍历广度优先之字形3{
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
            if(res.size()%2==1) Collections.reverse(tmp);//通过res长度改变顺序
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(4);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(7);
        a.left.left.left = new TreeNode(123);
        a.left.left.right = new TreeNode(23);
        a.right.right = new TreeNode(21);
        a.right.left = new TreeNode(14);
        List<List<Integer>> list = levelOrder(a);
        System.out.println(list);
    }

}
