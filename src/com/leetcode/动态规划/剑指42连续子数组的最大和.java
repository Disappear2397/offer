package com.leetcode.动态规划;

import java.awt.desktop.SystemEventListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/10/28 10:20
 */
//简单动态规划 这个方法类似于滚动数组
public class 剑指42连续子数组的最大和{
    public static int maxSubArray(int[] nums){
        int pre=0,max=nums[0];
        for(int i:nums) {
            pre = Math.max(pre+i, i);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxSubArray(a));


    }

}
