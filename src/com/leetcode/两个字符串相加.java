package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/16 16:24
 */
public class 两个字符串相加{
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - 48 : 0;
            int y = j >= 0 ? num2.charAt(j) - '0': 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String a="4546545612";
        String b="16165121212112";
        System.out.println(addStrings(a,b));
    }
}
