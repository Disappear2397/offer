package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/5 14:20
 */
//每个数字只能使用一次 需要去重（指的是相同组合，不是相同数字）


// 这种更易懂 首选 注意剪枝部分
public class 组合总和2{
    static List<List<Integer>> list=new ArrayList<>();
    static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> combinationSum21(int[] candidates, int target) {
        Arrays.sort(candidates);//不可省略
        dfs(candidates,target,0);
        return list;
    }
    private static void dfs(int[] candidates, int target,int index){
        if(target==0){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]<=target){
                if(i>index&&candidates[i]==candidates[i-1]){//出现重复节点，要对同一树层使用过的元素进行跳过 如防止出现两个 1,2,5
                    // 剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates,target-candidates[i],i+1);
                path.remove(path.size()-1);//1,1,2,5,6,7,10
            }
        }
    }

    //官方答案也不推荐 这是精选答案 和上一个方法类似
    public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 关键步骤
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs1(candidates, len, 0, target, path, res);
        return res;
    }
    private static void dfs1(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs1(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
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
        System.out.println("输入目标值：");
        int i = sc.nextInt();
        System.out.println(combinationSum22(a,i));
    }
}
