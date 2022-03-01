package com.leetcode.排序;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/1 21:07
 */
public class 剑指40最小的k个数{
    //排序
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] a = new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            a[i]=arr[i];
        }
        return a;
    }
    //大顶堆
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });//大顶堆的定义 要找前k个最小数，则构建大顶堆，要重写compare方法
        //PriorityQueue<Integer> pq = new PriorityQueue<>(k);//队列默认自然顺序排列，小顶堆，不必重写compare
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {//如果堆顶元素 > 新数，则删除堆顶，加入新数入堆
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
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
        System.out.println(Arrays.toString(getLeastNumbers1(a,k)));
    }

}
