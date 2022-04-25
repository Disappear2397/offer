package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/24 20:05
 */
public class 二叉树的路径总和3{
    //求二叉树里节点值之和等于targetSum的路径的数目
    //路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
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
    public static int pathSum(TreeNode root,int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = dfs(root,targetSum);
        count += pathSum(root.left,targetSum);
        count += pathSum(root.right,targetSum);
        return count;
    }
    // 返回经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
    public static int dfs(TreeNode root,int targetSum) {
       int count = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            count++;
        }
        count += dfs(root.left,targetSum - val);
        count += dfs(root.right,targetSum - val);
        return count;
    }
}
