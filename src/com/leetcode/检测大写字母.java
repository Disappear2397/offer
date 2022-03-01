package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/5 21:49
 */
public class 检测大写字母{
    public boolean detectCapitalUse1(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                // ^:异或   isLowerCase：用于检查给定的char值是否为小写
                return false;
            }
        }
        return true;
    }
    public boolean detectCapitalUse2(String word) {
        if (word.toUpperCase().equals(word)) return true;//toUpperCase()返回一个新的字符串，其中的文本全部为大写。
        if (word.toLowerCase().equals(word)) return true;
        int n = word.length(), idx = 1;
        if (Character.isUpperCase(word.charAt(0))) {
            while (idx < n && Character.isLowerCase(word.charAt(idx))) idx++;
        }
        return idx == n;
    }


}
