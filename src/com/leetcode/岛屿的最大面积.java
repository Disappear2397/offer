package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/2/25 16:25
 */
public class 岛屿的最大面积{
    //深度优先，递归
    public static int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        int ans = 1;
        grid[r][c] = 0;//没搜索一个1就标记为0
        for (int index = 0; index < 4; index++) {
            int next_r = r + di[index], next_c = c + dj[index];
            ans += dfs(grid,next_r,next_c);
        }
        return ans;
    }
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int area = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                area = Math.max(area, dfs(grid,r,c));
            }
        }
        return area;
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
        System.out.println(maxAreaOfIsland(a));
    }
}
