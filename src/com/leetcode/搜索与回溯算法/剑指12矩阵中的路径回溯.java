package com.leetcode.搜索与回溯算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/29 11:43
 */
public class 剑指12矩阵中的路径回溯{
    //深度优先 回溯 与力扣79题单词搜索一模一样
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //剪枝  注意（1）当前矩阵元素与目标字符不同（2）当前矩阵元素已访问过可合并成一个  board[i][j] != word[k]
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';//标记此元素已访问
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];//还原当前矩阵元素
//        System.out.println(Arrays.deepToString(board));
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个单词：");
        String word = scanner.next();
        System.out.println("输入二维数组行数");
        int r = scanner.nextInt();
        System.out.println("输入二维数组列数");
        int c = scanner.nextInt();
        char[][] a = new char[r][c];
        System.out.println("输入二维数组的字符");  //输入一个字符二维数组

        for (int i = 0; i < r; i++) {
            String s = scanner.next();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        System.out.println(exist(a,word));
    }
}
