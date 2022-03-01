package com.leetcode.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/28 21:17
 */
public class 剑指46把数字翻译成字符串{
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
    //类似于爬楼梯
    public static int numWays1(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int[] dp = new int[ch.length + 1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= ch.length; i++){
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if(n >= 10 && n <= 25){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[ch.length];

    }

    public static void main(String[] args) {
        System.out.println("输入一个数字字符串：");
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        System.out.println(numWays1(sc));
    }
}
