package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/2/24 19:53
 */
//环状打劫
public class 打家劫舍2{
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(getrob(nums,0,length-2),getrob(nums,1,length-1));
    }
    public static int getrob(int[] nums,int start,int end){
        int first = nums[start], second = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i <= end; i++){
            int temp = second;
            second = Math.max(first + nums[i],second);
            first = temp;
        }
        return second;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数组：");
        String next = scanner.next();
        String[] s = next.split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(rob(nums));
    }
}
