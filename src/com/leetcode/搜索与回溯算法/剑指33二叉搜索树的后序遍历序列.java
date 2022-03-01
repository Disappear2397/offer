package com.leetcode.搜索与回溯算法;

import java.util.Stack;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/19 14:22
 */
public class 剑指33二叉搜索树的后序遍历序列{
    //单调栈
    public boolean verifyPostorder1(int[] postorder) {
        //借助一个单调栈stack存储值递增的节点
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false; //若节点r>root，则说明不满足二叉搜索树定义
            while(!stack.isEmpty() && stack.peek() > postorder[i])//每当遇到值递减的节点r,则通过出栈更新节点r的父节点root；
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
    //递归 官方 更清晰简单
    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
