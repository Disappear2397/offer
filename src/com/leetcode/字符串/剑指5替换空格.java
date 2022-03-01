package com.leetcode.字符串;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/17 17:03
 */
public class 剑指5替换空格{
    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for(char c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
