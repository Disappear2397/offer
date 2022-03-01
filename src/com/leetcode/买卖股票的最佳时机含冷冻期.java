package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/21 11:22
 */
public class 买卖股票的最佳时机含冷冻期{
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        //注意只有买入有冷冻期
        // f[i][0]: 手上持有股票的最大收益（分为前一天买入和当天买入）
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益（说明当天卖掉了股票）
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益（说明当天没进行任何操作，1,前一天不持有股票，分是否是冷冻期俩种情况两种情况）
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);//输出不持有股票的最大值，是否是冷冻期无所谓
    }


    ////不用数组存状态，不必存储无关的状态，直接用变量

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];//持有股票（分为前一天买入和当天买入）
        int f1 = 0;//不持有股票，且处于冷冻期（说明当天卖掉了股票）
        int f2 = 0;//不持有股票，且不处于冷冻期（说明当天没进行任何操作，1,前一天不持有股票，是否是冷冻期俩种情况）
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }

}
