package com.leetcode.排序;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/11 10:10
 */
//小顶堆 map存储
public class 前k个高频元素{
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int num : nums) {
            res.put(num, res.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数   小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
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
        System.out.println(Arrays.toString(topKFrequent(a,k)));
    }
}
