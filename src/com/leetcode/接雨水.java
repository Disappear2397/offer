package com.leetcode;

import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/7 10:56
 */
public class 接雨水{
    //双指针
//    对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
//    下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去height[i]
 //   注意到下标 i 处能接的雨水量由leftMax[i] 和 rightMax[i] 中的最小值决定
    public static int trap1(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }


    //动态规划
//    显然leftMax[0]=height[0],rightMax[n−1]=height[n−1]。两个数组的其余元素的计算如下：(n是下标长度)
//    当1≤i≤n−1 时，leftMax[i]=max(leftMax[i−1],height[i])；
//    当 0≤i≤n−2 时，rightMax[i]=max(rightMax[i+1],height[i])。
//    对于0≤i<n，下标 i 处能接的雨水量等于 min(leftMax[i],rightMax[i])−height[i]。遍历每个下标位置即可得到能接的雨水总量
    public static int trap2(int[] height){
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入height数组：");
        String s = scanner.next();
        String[] arr = s.split(",");
        int[] a = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(trap1(a));
    }

}
