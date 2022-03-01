package com.leetcode.动态规划;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/19 10:55
 */
public class 剑指19正则表达式匹配{
    //动态规划
    public static boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean f[][] = new boolean[m + 1][n + 1];
        f[0][0] = true;//f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符）
        for(int i = 0; i <= m ; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(p.charAt(j - 1) == '*') {//p的第j个字符为*
                    if(matches(s, p, i, j - 1)) {//匹配s的第i个字符和p的第j-1个字符
                        f[i][j] = f[i - 1][j] || f[i][j - 2];//p中*前面的字符在s中出现多次(f[i - 1][j])或者在s中只出现1次(f[i][j - 2])
                    }
                    else {
                        f[i][j] = f[i][j - 2];//p中*前面的在s中字符出现0次
                    }
                }
                else {//p的第j个字符不为*
                    if(matches(s, p, i, j)) {//匹配s的第i个字符和p的第j个字符
                        f[i][j] = f[i - 1][j - 1];//匹配成功，状态转移；匹配不成功，默认是false
                    }
                }
            }
        }
        return f[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {//注意在字符串中的下标变换
        if(i == 0) {
            return false;
        }
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);//返回s中第i个元素和p中第j个元素的匹配情况
    }

    //动态规划易懂版
    public static boolean isMatch2(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];// f[i][j]表示 s 的前 i 个字符与 pp 中的前 j 个字符是否能够匹配

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0; //1.空串和空正则是匹配的，f[0][0] = true
                                        // 2.非空串和空正则必不匹配，f[1][0]=...=f[n][0]=false
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {//正常字符或者“.”情况   长度都为1时也是这种情况
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s = scanner.next();
        System.out.println("输入正则字符串：");
        String p = scanner.next();
        System.out.println(isMatch2(s,p));
    }

}
