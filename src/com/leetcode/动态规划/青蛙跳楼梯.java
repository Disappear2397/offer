package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/25 16:35
 */
public class 青蛙跳楼梯{
    public static int numWays(int n) {
        int MOD = 1000000007;
        if (n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int i = scanner.nextInt();
        System.out.println(numWays(i));
    }
}
