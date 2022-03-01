package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/9/25 20:46
 */
//力扣46 47 题 对int数组进行全排列 46：无重复 47：有重复
public class 全排列无重复{
    //无重复
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {

            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入一个数组方法
        System.out.println("请输入数组，每个数用逗号隔开：");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] a = new int[arr.length];
        for(int j = 0; j<a.length;j++) {
            a[j] = Integer.parseInt(arr[j]);
        }
        System.out.println(permute(a));
    }
}
