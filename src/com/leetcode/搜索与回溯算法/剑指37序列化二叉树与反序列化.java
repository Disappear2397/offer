package com.leetcode.搜索与回溯算法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/17 11:07
 */
public class 剑指37序列化二叉树与反序列化{
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//深度优先搜索序列化与反序列化
    public String serialize(TreeNode root) {
      return rserialize(root, "");
  }
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
//括号表示编码 + 递归下降解码
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder s = new StringBuilder();
        s.append(root.val);
        s.append(",");
        s.append(serialize(root.left));
        s.append(",");
        s.append(serialize(root.right));
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {

        String[] strs = data.split(",");
        TreeNode root = deserialize(strs, new int[]{0});
        return root;
    }
    public TreeNode deserialize(String[] strs, int[] i) {
        if (strs.length <= i[0] || strs[i[0]].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[i[0]]));
        i[0]++;//跳过左括号
        node.left = deserialize(strs, i);
        i[0]++;//跳过右括号
        node.right = deserialize(strs, i);

        return node;
    }
}
