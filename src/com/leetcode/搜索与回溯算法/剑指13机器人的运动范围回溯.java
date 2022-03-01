package com.leetcode.搜索与回溯算法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/31 19:23
 */
//只能用动态规划(递推稍简单)
public class 剑指13机器人的运动范围回溯{
    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;  //若满足if语句就是一直向i++j++移动，下面的也不执行，不满足if语句才执行下面
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m=16,n=8,k=4;
        System.out.println(movingCount(m,n,k));
    }

}
