package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/6/29 15:10
 */
public class Main{
    public static String compressString(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.leetcode.Test");
            System.out.println("A");
            Object inst = aClass.newInstance();
        }catch (ClassNotFoundException|IllegalAccessException|InstantiationException e){
            e.printStackTrace();
        }
    }
}
