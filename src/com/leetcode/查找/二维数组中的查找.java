package com.leetcode.查找;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 14:11
 */
public class 二维数组中的查找{
    public  static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("输入二维数组的行列数：");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] a = new int[r][c];
        System.out.println("输入二维数组的值：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        System.out.println(findNumberIn2DArray(a,5));
            }

}
