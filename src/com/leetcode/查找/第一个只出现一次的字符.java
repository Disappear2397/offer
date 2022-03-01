package com.leetcode.查找;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 16:01
 */
public class 第一个只出现一次的字符{
    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(firstUniqChar(str));
    }
}
