package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/2/24 19:58
 */
public class 打家劫舍3{
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //树状打劫，见337题  哈希表存储
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();//f表示选当前节点
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();//g表示不选当前节点

    public int rob1(TreeNode root) {
        dfs1(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs1(node.left);
        dfs1(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

    //优化
    public int rob2(TreeNode root) {
        int[] rootStatus = dfs2(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public static int[] dfs2(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs2(node.left);
        int[] r = dfs2(node.right);
        int selected = node.val + l[1] + r[1];//表示选当前节点 加上不选该节点的左右子树
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);//表示不选当前节点 加上该节点的左右子树
        return new int[]{selected, notSelected};
    }
}
