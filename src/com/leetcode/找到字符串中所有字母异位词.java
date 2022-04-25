package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/25 12:37
 */
public class 找到字符串中所有字母异位词{
    //滑动数组
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];//存储s的
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {//先创建长度与字符串p的长度相同的窗口
            ++sCount[s.charAt(i) - 'a'];//-‘0’或者-48是为了将字符（原字符是数字）转为数字  -'a'或者-97 也是将字符（原字符是字母）转为数字
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];//滑动数组左侧向前移动一格
            ++sCount[s.charAt(i + pLen) - 'a'];//滑动数组右侧向前移动一格

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
