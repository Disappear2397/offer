package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/30 10:56
 */
public class 单词拆分{
    //动态规划 自底向上
    //dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i-1]是否能被空格拆分成若干个字典中出现的单词
    //转移方程：dp[i]=dp[j] && check(s[j..i−1])
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串:");
        String s = scanner.next();
        System.out.println("输入字符串列表：");
        String[] word = scanner.next().split(",");
        List<String> wordDict = new LinkedList<>();
        for (int i = 0; i < word.length; i++) {
            wordDict.add(word[i]);
        }
        System.out.println(wordBreak(s,wordDict));
    }
}
