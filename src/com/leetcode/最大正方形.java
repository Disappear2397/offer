package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/10 14:44
 */
public class 最大正方形{
    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];//最大边长值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        //规划方程：当前的正方形有三种情况转换，左上、坐下、右上
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
    public static void main(String[] args) {
        System.out.println("输入二维数组的行列数：");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        char[][] a = new char [r][c];
        System.out.println("输入二维数组的值：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = (char)(scanner.nextInt()+'0');//int数组转换成char数组 需要强转前需要 + ’0‘
                //Integer.parseInt(String.valueOf(ch[i])) //这是char数组转换成int数组
            }
        }
        System.out.println(maximalSquare(a));
    }
}
