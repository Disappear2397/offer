package com.leetcode;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/2 11:00
 */
public class 完全平方数{
    //动态规划 f[i] 表示最少需要多少个数的平方来表示整数 i     规划方程：f[i]= 1+ min{f[i-j^2]}
    //这些数必然落在区间[1,n]。我们可以枚举这些数，假设当前枚举到 j，那么我们还需要取若干数的平方，构成 i-j^2.
    public static int numSquares(int n) {
        int[] f = new int[n + 1];
//        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
        f[i] = min + 1;
        }
        return f[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(numSquares(i));

    }

}
