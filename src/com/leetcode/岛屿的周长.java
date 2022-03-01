package com.leetcode;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/2/25 19:13
 */
public class 岛屿的周长{
    //深度优先 递归
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }
    //遍历每个陆地格子，看其四个方向是否为边界或者水域,有水域说明是周长的一个边
    public static int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;//已经被标记的格子
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
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
        System.out.println(islandPerimeter(a));
    }
}
