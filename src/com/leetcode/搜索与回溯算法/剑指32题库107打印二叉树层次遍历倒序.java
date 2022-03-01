package com.leetcode.搜索与回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/19 16:24
 */
public class 剑指32题库107打印二叉树层次遍历倒序{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0,tmp);//在插入操作过程中指定插入的位置，第一个参数是位置，第二个是参数
            //只需在res上0的位置一直插入即可
        }
        return res;
    }

}
