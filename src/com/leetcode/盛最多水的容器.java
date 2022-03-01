package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/27 20:01
 */
public class 盛最多水的容器{
    public static int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int s = 0;
        while (l < r){
            int area = (r-l) * Math.min(height[l],height[r]);
            s = Math.max(s,area);
            if (height[l] < height[r]) ++l;
            else  --r;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入高度数组：");
        String s = scanner.next();
        String[] str = s.split(",");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        System.out.println(maxArea(a));
    }

}
