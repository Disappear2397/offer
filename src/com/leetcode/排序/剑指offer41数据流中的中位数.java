package com.leetcode.排序;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/2 10:39
 */
public class 剑指offer41数据流中的中位数{
    Queue<Integer> A, B;
    public void MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半  默认
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
