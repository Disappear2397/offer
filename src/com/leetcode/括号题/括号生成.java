package com.leetcode.括号题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/30 13:42
 */
public class 括号生成{
    //回溯 生成n对括号
    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        //open: "(" close: ")" max: 括号对数
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {//左括号没匹配完
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    //回溯 易懂
//    List<String> ret = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        String test = new String();
//        backTrace(n, n, test);
//        return ret;
//    }
//  left:剩余没使用的“）”  right:剩余没使用的“(”
//    public void backTrace(int left, int right, String test) {
//        if (left == 0 && right == 0) {
//            ret.add(test);
//            return;
//        }
//        if (left > right || left < 0 || right < 0) {
//            return;
//        }
//        backTrace(left - 1, right, test+"(");
//        backTrace(left, right - 1, test + ")");
//    }
    //简单dfs
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis2(int n) {
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余的多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入括号对数：");
        int i = scanner.nextInt();
        System.out.println(generateParenthesis1(i));
    }
}
