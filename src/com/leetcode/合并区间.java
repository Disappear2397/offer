package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/9 16:01
 */
public class 合并区间{
    public static int[][] merge(int[][] arr) {
        if(arr == null || arr.length<=1)
            return arr;
        List<int[]> list = new ArrayList<>();
        //Arrays.sort(arr,(a,b)->a[0]-b[0]); //lamda 表达式
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];//对起点和终点分别进行排序，将起点和终点一一对应形成一个数组
            }
        });
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int left = arr[i][0];
            int right = arr[i][1];
            while(i<n-1 && right >= arr[i+1][0]){
                right = Math.max(right,arr[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println("输入区间的个数：");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int[][] a = new int[r][2];
        System.out.println("输入区间的值：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(merge(a)));//将多维数组转换成字符串用deepToString
    }
}
