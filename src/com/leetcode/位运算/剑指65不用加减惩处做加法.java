package com.leetcode.位运算;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/9 11:30
 */
public class 剑指65不用加减惩处做加法{//位运算
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位  与运算然后再左移一位
            a ^= b; // a = 非进位和  异或运算
            b = c; // b = 进位
        }
        return a;
    }
}
