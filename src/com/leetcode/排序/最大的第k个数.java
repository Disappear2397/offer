package com.leetcode.排序;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/10 14:22
 */
public class 最大的第k个数{
    public static int findKthLargest(int[] nums, int k) {
        int[] vec = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);//小顶堆
        for(int i = 0;i< k ;++i){
            queue.offer(nums[i]);
        }
        for(int i = k;i< nums.length;++i){
            if(queue.peek() < nums[i]){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }
    public static void main(String[] args) {
        System.out.println("请输入任意个数字：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println("请输入k：");
        Scanner scanner1 = new Scanner(System.in);
        int k =scanner1.nextInt();
        System.out.println(findKthLargest(a,k));
    }
}
