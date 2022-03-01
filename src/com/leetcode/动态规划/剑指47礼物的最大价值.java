package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/28 11:16
 */
public class 剑指47礼物的最大价值{
    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入二维数组行数");
        int r = scanner.nextInt();
        System.out.println("输入二维数组列数");
        int c = scanner.nextInt();
        int[][] a = new int[r][c];
        System.out.println("输入二维数组的值");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxValue(a));
    }
}