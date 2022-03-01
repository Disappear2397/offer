package com.leetcode.搜索与回溯算法;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/17 15:22
 */
//list解法 剑指中还有set解法
public class 剑指38字符串排列有重复全排列{
    public static List<String> rec;
    public static boolean[] vis;
    public static String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];//用vis记录每次访问过的char
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public static void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            //不重复：我们只要在递归函数中设定一个规则，保证在填每一个空位的时候重复字符只会被填入一次。
            // 具体地，我们首先对原字符串排序，保证相同的字符都相邻，
            // 在递归函数中，我们限制每次填入的字符一定是这个字符所在重复字符集合中「从左往右第一个未被填入的字符」，
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请一个字符串：");
        String str = sc.next();
        System.out.println(Arrays.toString(permutation(str)));
    }
}
