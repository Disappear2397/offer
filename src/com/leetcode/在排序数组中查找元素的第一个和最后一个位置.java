package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/3 12:27
 */
public class 在排序数组中查找元素的第一个和最后一个位置{
    //官方
    public static int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);//在数组中寻找第一个大于等于target的下标
        int rightIdx = binarySearch(nums, target, false) - 1;//在数组中寻找第一个大于target 的下标-1
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;


    }

    //官方简化
    public static int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target - 1);//找到第一个大于target-1的下标
        int rightIdx = binarySearch(nums, target) - 1;//找到第一个大于target的下标
        if (leftIdx <= rightIdx && nums[leftIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    // 第一个大于 target 的数的下标
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组：");
        String s = scanner.next();
        String[] arr = s.split(",");
        int[] a = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println("请输入目标值：");
        int b = scanner.nextInt();
        System.out.println(Arrays.toString(searchRange2(a,b)));
    }
}
