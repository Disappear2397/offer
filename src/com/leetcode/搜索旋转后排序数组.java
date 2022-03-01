package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/2 11:35
 */
public class 搜索旋转后排序数组{
   //二分法
   //其实题目要求还是求某个值在数组中的坐标，但是遍历的方法时间复杂度高，需要利用旋转过的升序数组这个条件来优化时间复杂度
   //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
   public static int search(int[] nums, int target) {
       int n = nums.length;
       if (n == 0) {
           return -1;
       }
       if (n == 1) {
           return nums[0] == target ? 0 : -1;
       }
       int l = 0, r = n - 1;
       while (l <= r) {
           int mid = (l + r) / 2;
           if (nums[mid] == target) {
               return mid;
           }
           if (nums[0] <= nums[mid]) { //左边数量大于右边数量
               if (nums[0] <= target && target < nums[mid]) {
                   r = mid - 1;
               } else {
                   l = mid + 1;
               }
           } else {//左边数量小于右边数量
               if (nums[mid] < target && target <= nums[n - 1]) {
                   l = mid + 1;
               } else {
                   r = mid - 1;
               }
           }
       }
       return -1;
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
        System.out.println(search(a,b)
        );
    }
}
