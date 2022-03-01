package com.leetcode.数学;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/23 11:19
 */
public class 剑指431到n整数中1出现的次数{
    //纯数学递推问题 将数字看成三个部分：high+cur+low
    public static int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;//从最低位开始
        while(high != 0 || cur != 0) {//当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;//cur=2~9时
            low += cur * digit;//将 cur 加入 low ，组成下轮 low
            cur = high % 10;//下轮 cur 是本轮 high 的最低位
            high /= 10;//将本轮 high 最低位删除，得到下轮 high
            digit *= 10;//位因子每轮 × 10
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int i = scanner.nextInt();
        System.out.println(countDigitOne(i));
    }
}
