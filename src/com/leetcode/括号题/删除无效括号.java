package com.leetcode.括号题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/5 13:30
 */
public class 删除无效括号{
    //回溯 剪枝  比较难
    private static List<String> res = new ArrayList<String>();

    public static List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }//此时求出需要被删除的左括号lremove和右括号rremove
        helper(s, 0, lremove, rremove);

        return res;
    }

    //遍历所有可能的去掉非法括号的方案
    private static void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {//每次进行搜索时，如果遇到连续相同的括号我们只需要搜索一次即可。不管去除哪个结果都是一样的
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {//剩余未尝试的字符串的长度小于 lremove+rremove 时，则停止本次搜索
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private static boolean isValid(String str) {//检测剩余的字符串是否合法匹配
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(removeInvalidParentheses(next));
    }
}
