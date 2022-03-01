package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/17 14:09
 */
public class 不同的二叉搜索树{
    //假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
    // 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
    // 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
    // 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    //动态规划
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    //也可用数学推导公式卡塔兰数
}
