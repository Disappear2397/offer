package com.leetcode.搜索与回溯算法;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/3 11:07
 */
public class 剑指36二叉搜索数与双向链表{
     class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;//也可放在上面ifelse之前
        pre = cur;
        dfs(cur.right);
    }


}
