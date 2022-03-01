package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/10 12:58
 */
public class 不同路径3有障碍物有固定起始位置{
    //回溯深度优先搜索
    //我们尝试遍历每一个 0 方格，并在走过的方格里留下一个障碍。回溯的时候，我们要删除那些自己留下的障碍。
    static int ans;
    static int[][] grid;
    static int tr, tc;
    static int[] dr = new int[]{0, -1, 0, 1};
    static int[] dc = new int[]{1, 0, -1, 0};//dr dc 俩俩对应分别代表上下左右移动
    static int R, C;

    public static int uniquePathsIII(int[][] grid) {
        不同路径3有障碍物有固定起始位置.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int todo = 0;
        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r) //首先遍历得到起始位置和可通过方格位置的个数
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] != -1) {
                    todo++;
                }

                if (grid[r][c] == 1) {//开始位置
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {//结束位置
                    tr = r;
                    tc = c;
                }
            }

        ans = 0;
        dfs(sr, sc, todo);
        return ans;
    }

    public static void dfs(int r, int c, int todo) {
        todo--;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0) ans++;
            return;
        }

        grid[r][c] = 3;
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];//分别指上下左右移动
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0)
                    dfs(nr, nc, todo);
            }
        }
        grid[r][c] = 0;//回溯将标记为3的返回为0
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
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(uniquePathsIII(a));//将多维数组转换成字符串用deepToString
    }
}
