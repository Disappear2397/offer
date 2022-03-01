package com.leetcode;


import org.junit.Test;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/6/25 13:20
 */

public class 两数之和{
    public static void main(String args[]) {
        int [] nums ={1,2,5,6};
        int target = 7;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    int[] ints = {i, j};
                    System.out.println(ints);
                }
            }
        }

    }


}
