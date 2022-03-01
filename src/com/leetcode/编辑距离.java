package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/12 14:48
 */
public class 编辑距离{
    //动态规划
    //D[i][j]表示 A的前i个字母和B的前j个字母之间的编辑距离
    /*分为三种情况：1.在单词 A 中插入一个字符；2.在单词 B 中插入一个字符；3.修改单词 A 的一个字符*/
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {//分为三种情况
                int left = D[i - 1][j] + 1;//对于 B 的第 j 个字符，我们在 A 的末尾添加了一个相同的字符
                int down = D[i][j - 1] + 1;//对于 A 的第 i 个字符，我们在 B 的末尾添加了一个相同的字符
                int left_down = D[i - 1][j - 1];//对于 B 的第 j 个字符，我们修改 A 的第 i 个字符使它们相同
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {//如果 A 的第 i 个字符和 B 的第 j 个字符原本就相同，那么我们实际上不需要进行修改操作。
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个单词：");
        String A = scanner.next();
        String B = scanner.next();
        System.out.println(minDistance(A,B));
    }
}
