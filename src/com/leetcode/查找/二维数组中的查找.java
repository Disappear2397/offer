package com.leetcode.查找;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 14:11
 */
public class 二维数组中的查找{
    //搜索普通二维数组
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
    //搜索行和列都是升序的二维数组  Z字型搜索（每次搜索可以排除一行或一列的元素） 或者用二分查找（可以排除半行或半列的元素）
    //Z字型搜索（每次搜索可以排除一行或一列的元素）
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x= 0, y= n-1;//从数组右上角开始搜索
        while (x < m && y >= 0){
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] > target) --y;
            else ++x;
        }
        return false;
    }
    //用二分查找（可以排除半行或半列的元素）
    public static boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix){
            int result = search(row, target);
            if (result >= 0){
                return true;
            }
        }
        return false;
    }
    private static int search(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = row[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
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
        System.out.println(searchMatrix2(a,-1));
            }

}
