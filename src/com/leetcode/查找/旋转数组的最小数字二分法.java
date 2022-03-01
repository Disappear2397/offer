package com.leetcode.查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 15:01
 */
public class 旋转数组的最小数字二分法{
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {

        System.out.println("请输入任意个数字：");
        Scanner in=new Scanner(System.in);
        String str=in.next().toString();
        String[]  arr=str.split(",");
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(minArray(a));
    }

}


