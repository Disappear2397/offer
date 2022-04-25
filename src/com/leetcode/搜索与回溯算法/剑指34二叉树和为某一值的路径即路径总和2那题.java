package com.leetcode.搜索与回溯算法;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/2 15:19
 */
public class 剑指34二叉树和为某一值的路径即路径总和2那题{
    //找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //深度优先 dfs  优先
    static List<List<Integer>> ret = new LinkedList<List<Integer>>();
    static Deque<Integer> path = new LinkedList<Integer>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public static void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }


    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path1 = new LinkedList<>();
    public static List<List<Integer>> pathSum1(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    static void recur(TreeNode root, int tar) {
        if(root == null) return;
        path1.add(root.val);//默认添加在队尾
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path1));
        recur(root.left, tar);
        recur(root.right, tar);
        path1.removeLast();
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(4);
        a.right = new TreeNode(8);
        a.left.left = new TreeNode(11);
        a.left.left.left = new TreeNode(7);
        a.left.left.right = new TreeNode(2);
        a.right.right = new TreeNode(4);
        a.right.right.left = new TreeNode(5);
        a.right.right.right = new TreeNode(1);
        a.right.left = new TreeNode(13);
        List<List<Integer>> list = pathSum1(a,22);
        System.out.println(list);
    }




    //广度优先 bfs
    static List<List<Integer>> ret1 = new LinkedList<List<Integer>>();
    static Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public static List<List<Integer>> pathSum2(TreeNode root, int target) {
        if (root == null) {
            return ret1;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == target) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret1;
    }

    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret1.add(new LinkedList<Integer>(temp));
    }


}
