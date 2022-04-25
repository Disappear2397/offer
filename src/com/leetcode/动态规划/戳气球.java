package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/8 11:30
 */
public class 戳气球{
    //动态规划max  自底向上 将全过程看作是每次添加一个气球  dp[i][j] 表示填满开区间 (i,j)能得到的最多硬币数   将全过程看作是每次添加一个气球
//     dp[i][j] = max(val[i]×val[k]×val[j])+dp[i][k]+dp[k][j]   i<j-1
//              = 0                                             i>j-1
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];//将其两边各加上题目中假设存在的nums[−1]和nums[n] ，并保存在val 数组中,防止下标越界
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] s = next.split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxCoins(arr));
    }
}
