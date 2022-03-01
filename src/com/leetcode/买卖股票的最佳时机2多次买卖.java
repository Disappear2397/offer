package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/21 10:27
 */
public class 买卖股票的最佳时机2多次买卖{
    //贪心算法  只要今天价格小于明天价格就在今天买入然后明天卖出 但是这样的过程不是实际的交易过程
    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=1; i < prices.length; i++){
            if(prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
    //动态规划
    /*第i天只有两个状态，不持有和持有股票 dp[i][0]表示第i天交易完不持有股票的最大利润, dp[i][1]表示第i天交易完持有股票的最大利润
    * 转移方程：dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}  其中+prices[i] 表示第i天卖出股票
    *         dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}  其中−prices[i] 表示第i天买入股票
    * 持有股票的收益一定低于不持有股票的收益，因此这时候dp[n−1][0] 的收益必然是大于dp[n−1][1] 的  */
    public  int maxProfit2(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0] ;
    }
    //不用数组存状态，不必存储无关的状态，直接用变量
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }


}
