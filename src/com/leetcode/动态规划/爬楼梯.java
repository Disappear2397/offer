package com.leetcode.动态规划;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 20:07
 */
public class 爬楼梯{
    //回溯
    public static int countNumber(int stepsNum) {
        int sum = 0;
        if (stepsNum == 0) {
            return 0;
        }
        if (stepsNum == 1) {
            return 1;
        } else if (stepsNum == 2) {
            return 2;
        } else if (stepsNum == 3) {
            return 4;
        } else if (stepsNum > 3) {
            return countNumber(stepsNum - 3) + countNumber(stepsNum - 2)
                    + countNumber(stepsNum - 1);
        }

        return sum;
    }
    //动态规划
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        for (int i = 0; i <= 10; i++) {
            System.out.println("楼梯台阶数:" + i + ", 走法有:" + countNumber(i));
        }
    }
}
