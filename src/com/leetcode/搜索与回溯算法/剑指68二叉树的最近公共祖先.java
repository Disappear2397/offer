package com.leetcode.搜索与回溯算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/4 22:08
 */

public class 剑指68二叉树的最近公共祖先{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归一   最简洁的答案
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }

    //递归二
    public static TreeNode ans;

    public void Solution() {
        剑指68二叉树的最近公共祖先.ans = null;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    //存储父节点 哈希表
    static Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    static Set<Integer> visited = new HashSet<Integer>();

    public static void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(3);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(2);
        a.left.right = new TreeNode(4);
        a.left.left.left = new TreeNode(1);
        int s = lowestCommonAncestor3(a, a.right, a.left.right).val;
        System.out.println(s);
    }
}
