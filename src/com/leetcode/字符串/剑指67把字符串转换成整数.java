package com.leetcode.字符串;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/18 22:14
 */
public class 剑指67把字符串转换成整数{
    public  static int strToInt1(String str){
        str=str.strip();//删除首尾空格
        char[] c = str.toCharArray();
        if(str.length() == 0) return 0;
        int i = 1, sign = 1;
        int res = 0, bndry = Integer.MAX_VALUE/10;
        if(c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i;j < c.length;j++){
            if(c[j] < '0' || c[j]>'9') break;
            if(res > bndry || res == bndry && c[j] >'7') return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            //判断 res 在此轮拼接后是否超过 2147483647
            res = res * 10 + (c[j] -'0');
        }
        return sign * res;
    }
    //不使用trim()/strip()方法
    public static int strToInt2(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String s = scanner.next();
        System.out.println(strToInt1(s));
    }
}
