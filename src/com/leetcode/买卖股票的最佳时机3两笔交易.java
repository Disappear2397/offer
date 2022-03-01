package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/21 10:28
 */
public class 买卖股票的最佳时机3两笔交易{
    //动态规划
    /*四个状态：1.只进行过一次买操作；buy1
    2.进行了一次买操作和一次卖操作，即完成了一笔交易；sell1
    3.在完成了一笔交易的前提下，进行了第二次买操作；buy2
    4.完成了全部两笔交易。sell2*/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;//sell1 = 0相当于同天买卖所以利润是零
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
        //如果最优的情况对应的是恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，从sell1转移到sell2，因此最终答案即为sell2
    }
}
