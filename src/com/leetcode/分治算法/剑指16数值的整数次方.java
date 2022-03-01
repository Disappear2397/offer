package com.leetcode.分治算法;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/8 10:16
 */
public class 剑指16数值的整数次方{
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;//b & 1判断二进制最右一位值
            x *= x;
            b >>= 1; //右移一位相当于向下整除
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("输入x和幂数n：");
        int x = s.nextInt();
        int n = s.nextInt();
        System.out.println(myPow(x,n));
    }
}
