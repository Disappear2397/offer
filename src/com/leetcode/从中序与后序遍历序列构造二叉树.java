package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/19 15:11
 */
public class 从中序与后序遍历序列构造二叉树{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, 从中序与后序遍历序列构造二叉树.TreeNode left, 从中序与后序遍历序列构造二叉树.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //推荐递归
    //使用哈希表来帮助我们快速地定位根节点。对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置

    // 构造中序哈希映射，帮助我们快速定位根节点
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // 将中序遍历放到map中
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        // 根节点在后序遍历中的下标
        int postorder_root = postorder_right;
        // 根节点在中序遍历中的根节点
        int inorder_root = map.get(postorder[postorder_root]);
        // 左子树的长度
        int size_left_subtree = inorder_root - inorder_left;
        // 建立根节点
        TreeNode root = new TreeNode(postorder[postorder_root]);

        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + size_left_subtree - 1);
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_left + size_left_subtree, postorder_right - 1);
        return root;
    }
    //还可以用栈，迭代，比较麻烦
    /*1.我们用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（后序遍历的最后一个节点），指针指向中序遍历的最后一个节点；
    2.我们依次枚举后序遍历中除了第一个节点以外的每个节点。如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向左移动 index，
    并将当前节点作为最后一个弹出的节点的左儿子；如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的右儿子；
    3.无论是哪一种情况，我们最后都将当前的节点入栈*/
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

}
