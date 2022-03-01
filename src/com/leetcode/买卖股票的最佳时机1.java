package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/21 10:27
 */
public class 买卖股票的最佳时机1{
    public static int maxProfit(int[] prices){
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min) min=prices[i];
            if(prices[i]-min>max) max=prices[i]-min;
        }
        return max;
    }
}
