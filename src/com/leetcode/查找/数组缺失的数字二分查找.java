package com.leetcode.查找;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/15 11:51
 */
public class 数组缺失的数字二分查找{
    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组内容并用逗号隔开:");
        String s = scanner.next();
        String[] a = s.split(",");
        int [] nums = new int[a.length];
        for (int i=0;i<a.length;i++){
            nums[i]=Integer.parseInt(a[i]);
        }
        System.out.println(missingNumber(nums));
    }
}

