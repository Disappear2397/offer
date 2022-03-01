package com.leetcode;

import java.util.*;


//找出所有相加之和为 n 的 k 个数的组合。 且所有数字都是正整数。解集不能包含重复的组合。
//套用前两题的方法
public class 组合总和3{
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        // 为了防止底层动态数组扩容，初始化的时候传入最大长度
        Deque<Integer> path = new ArrayDeque<>(k);//存储根节点开始的路径
        dfs3(1, k, path, n, res);
        return res;
    }

    public static void dfs3(int begin, int k, Deque<Integer> path, int target, List<List<Integer>> res) {
        // 1.结束条件
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        // 2.选择列表
        for (int i = begin; i < 10; i++) {
            // 大剪枝
            if (target - i < 0) return;
            // 选择
            path.addLast(i);
            // 递归
            dfs3(i + 1, k, path, target - i, res);
            // 撤销选择
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("和为n:");
        int n = scanner.nextInt();
        System.out.println("个数为k:");
        int k = scanner.nextInt();
        System.out.println(combinationSum3(k,n));
    }
}
