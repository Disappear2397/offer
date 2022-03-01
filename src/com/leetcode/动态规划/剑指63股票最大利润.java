package com.leetcode.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/26 10:30
 */
public class 剑指63股票最大利润{
//    public static int maxProfit(int[] prices){
//        int max=0;
//        for(int i=0;i<prices.length-1;i++){
//            for (int j=i+1;j<prices.length;j++){
//                if(prices[j]-prices[i]>max) max=prices[j]-prices[i];
//            }
//        }
//        return max;
//    }
    public static int maxProfit(int[] prices){
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min) min=prices[i];
            if(prices[i]-min>max) max=prices[i]-min;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("请输入任意个数字：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(a));
    }
}
