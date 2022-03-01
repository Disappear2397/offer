package com.leetcode;

import java.util.HashMap;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/24 10:49
 */
//一个出现一次的数字，其他都出现两次 和剑指56一稍有不同   只出现一次的数字3与剑指56一相同
public class 只出现一次的数字{
    //位运算
    /*任何数和 0 做异或运算，结果仍然是原来的数，即a⊕0=a。
        任何数和其自身做异或运算，结果是 00，即 a⊕a=0。
        异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b*/
    //数组中的全部元素的异或运算结果即为数组中只出现一次的数字
    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    //hashmap解法
    public static int  singleNumber2(int[] nums) {
        HashMap<Integer, Boolean> dic = new HashMap<>();
        for(int c : nums)
            dic.put(c, !dic.containsKey(c));
        for(int c : nums)
            if(dic.get(c)) return c;
        return ' ';
    }

}
