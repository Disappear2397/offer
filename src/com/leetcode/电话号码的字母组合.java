package com.leetcode;

import java.util.*;
import java.util.zip.DeflaterOutputStream;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/27 20:50
 */
public class 电话号码的字母组合{
    //回溯
    public static List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        HashMap<Character, String> map = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res, map, digits, 0, new StringBuffer());//用stringbuiler更快
        return res;
    }

    private static void backtrack(List<String> res, Map<Character,String> map, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            char digit = digits.charAt(index);//index是数字字符串的下标
            String letters = map.get(digit);//get指key对应的value指
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {//i是数字对应的字母字符串的下标
                sb.append(letters.charAt(i));
                backtrack(res, map, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入电话号码：");
        String s = scanner.next();
        System.out.println((letterCombinations(s)));
    }
}
