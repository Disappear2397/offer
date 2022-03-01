package com.leetcode.排序;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/22 12:59
 */
public class 剑指51数组中的逆序对个数归并排序{
    //分治算法  优化归并排序
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }
    //num[left...right]计算逆序对个数并排序
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;// left和right非常大时，left+right容易造成整型溢出，所以改为left + (right - left)，常出现在二分查找里
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) { //若整个已经是有序数组
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }
    //nums[left...mid]有序，nums[mid+1...right]有序
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {//i用完了，将剩下的右侧归并进去
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {//j用完了，将剩下的左侧归并进去
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {//归并左侧子序列时，才统计逆序对的个数
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
    //这一种更清晰，符合常理，常见的归并排序修改来的
//    int cnt = 0;
//    int[] temp;
//
//    public int reversePairs(int[] nums) {
//        int n = nums.length;
//        temp = new int[n];
//        mergeSort(nums, 0, n - 1);
//        return cnt;
//    }
//
//    private void mergeSort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        // 像不像二叉树的后序遍历？
//        int mid = (right - left) / 2 + left;
//        // 递 => 将数组分割成不可再分的小块
//        mergeSort(arr, left, mid);
//        mergeSort(arr, mid + 1, right);
//        // 归 => 逐步合并已完成排序的左右小块
//        merge(arr, left, mid, right);
//    }
//
//    private void merge(int[] arr, int left, int mid, int right) {
//        // 复制一下，准备归并
//        for (int i = left; i <= right; i++) {
//            temp[i] = arr[i];
//        }
//
//        // 修改原数组，归并 temp
//        int i = left, j = mid + 1, k = left;
//        while (i <= mid && j <= right) {
//            if (temp[i] > temp[j]) {
//                arr[k] = temp[j++];
//                // mid 前有多少个 temp[j] 比当前 temp[i] 小
//                cnt += mid - i + 1;
//            } else {
//                arr[k] = temp[i++];
//            }
//            k++;
//        }
//
//        while (i <= mid) {
//            arr[k++] = temp[i++];
//        }
//
//        while (j <= right) {
//            arr[k++] = temp[j++];
//        }
//    }
    public static void main(String[] args) {
        System.out.println("请输入一个数组并用，隔开：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(reversePairs(a));
    }
}
