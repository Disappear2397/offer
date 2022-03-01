package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/5 19:38
 */
public class 全排列有重复{
    static boolean[] vis;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {//剪枝，出现重复节点，要对同一树层使用过的元素进行跳过 如防止出现两个相同perm
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
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
        System.out.println(permuteUnique(a));
    }
}
