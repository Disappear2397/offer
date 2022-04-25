package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/24 15:36
 */
public class 分割等和子集{
    /*dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
    转移方程；dp[i][j]=  dp[i−1][j],          至少是这个答案，如果 dp[i−1][j] 为真，直接计算下一个状态
                       true,                nums[i] = j
                       dp[i−1][j−nums[i]]  nums[i] < j*/
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满    第0行其他数不用设置，不会影响结果
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split(",");
        int[] s = new int[split.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = Integer.parseInt(String.valueOf(s[i]));
        }
        System.out.println(canPartition(s));
    }
}
