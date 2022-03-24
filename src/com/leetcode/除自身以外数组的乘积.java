package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/24 15:29
 */
//当前位置的结果就是它左部分的乘积再乘以它右部分的乘积。因此需要进行两次遍历，第一次遍历用于求左部分的乘积，第二次遍历在求右部分的乘积的同时，再将最后的计算结果一起求出来
/*      原数组：       [1       2       3       4]
        左部分的乘积：   1       1      1*2    1*2*3
        右部分的乘积： 2*3*4    3*4      4      1
        结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1    */
public class 除自身以外数组的乘积{
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];//永远当前的那个num[i]没有计算
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] s = next.split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
