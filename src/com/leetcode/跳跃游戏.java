package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/9 15:42
 */
public class 跳跃游戏{
    //贪心算法
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;
        for (int i = 0; i < n; i++) {
            if(i <= far) {
                far = Math.max(far, i + nums[i]);//更新最远距离
                if (far >= n - 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个非负整数数组：");
        String s = scanner.next();
        String[] arr = s.split(",");
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(canJump(a));
    }
}
