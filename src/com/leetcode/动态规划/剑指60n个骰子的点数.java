package com.leetcode.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/21 13:57
 */
public class 剑指60n个骰子的点数{
    //动态规划 一维数组  （也可以用二维数组 dp[i][j]表示i个骰子总点数为j有多少种情况）
    /*由于新增骰子的点数只可能为 1 至 6 ，因此概率 f(n - 1, x) 仅与 f(n, x + 1)f(n,x+1) , f(n, x + 2)f(n,x+2), ... , f(n, x + 6)f(n,x+6) 相关。
    因而，遍历 f(n - 1)f(n−1) 中各点数和的概率，并将其相加至 f(n)f(n) 中所有相关项，即可完成 f(n - 1)f(n−1) 至 f(n)f(n) 的递推
     */

    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);//填充dp数组中的每个元素都是1/6
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入骰子个数：");
        int i = scanner.nextInt();
        System.out.println(Arrays.toString(dicesProbability(i)));
    }
}
