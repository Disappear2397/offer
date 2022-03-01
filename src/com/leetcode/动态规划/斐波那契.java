package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/25 14:31
 */
public class 斐波那契{
    public static int fib(int n) {
        int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int x = 0, y = 0, z = 1;
        for (int i = 2; i <= n; i++) {
            x = y;
            y = z;
            z = (x + y) % MOD;
        }
        return z;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int i = scanner.nextInt();
        System.out.println(fib(i));
    }
}
