package com.leetcode.模拟;

import java.util.*;



/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/16 11:37
 */
public class 剑指59滑动窗口的最大值用大顶堆{
    //单调队列（双端队列）
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) { //这个值在数组nums中的位置出现在滑动窗口左边界的左侧时。永久出队这个数
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    //优先队列
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayDeque<Integer> objects = new ArrayDeque<>();
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                // return pair2[0] - pair1[0] ; 都可以
            }
        });//大顶堆的定义 要重写compare方法
        //PriorityQueue<Integer> pq = new PriorityQueue<>(k);//队列默认自然顺序排列，小顶堆，不必重写compare
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {//这个值在数组nums中的位置出现在滑动窗口左边界的左侧时。永久出栈这个数
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
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
        System.out.println("请输入窗口大小：");
        Scanner scanner1 = new Scanner(System.in);
        int k =scanner1.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow2(a,k)));
    }

}
