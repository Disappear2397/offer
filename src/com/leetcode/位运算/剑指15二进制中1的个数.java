package com.leetcode.位运算;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/9 10:23
 */
public class 剑指15二进制中1的个数{
    //位运算优化
    public static int hammingWeight1(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1; //n & (n−1)，其预算结果恰为把n的二进制位中的最低位的 11 变为 00 之后的结果
            ret++;
        }
        return ret;
    }
    //库函数
    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("输入一个数：");
        int i = s.nextInt();
        System.out.println(hammingWeight1(i));
    }
}
