package com.leetcode.数学;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/14 16:01
 */
// 上三角乘下三角  递归
public class 剑指66构建乘积数组{
    public static int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意个数字：");
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(constructArr(a)));
    }
}
