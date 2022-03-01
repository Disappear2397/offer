package com.leetcode.数学;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/23 21:45
 */
public class 剑指44数学序列中的某一位的数字{
    //纯数学递推问题 将数字看成三个部分：high+cur+low
    public static int findNthDigit(int n) {
        int digit = 1;//位数
        long start = 1;//，每位数的起始数字
        long count = 9;
        while (n > count) { // 1.确定所求数位的躲在数字的位数
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.确定所求数位所在的数字
//        return (num+"").charAt((n - 1) % digit)-'0';  //num+""将num转换成string类型
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.确定所求数位在num的哪一数位  用Long.toString执行更快
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n：");
        int i = scanner.nextInt();
        System.out.println(findNthDigit(i));
    }
}
