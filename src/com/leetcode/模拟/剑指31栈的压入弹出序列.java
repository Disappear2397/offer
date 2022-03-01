package com.leetcode.模拟;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/16 10:04
 */
public class 剑指31栈的压入弹出序列{
    //栈
    public static boolean  validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();//使用栈时，用ArrayDeque的push和pop(出栈)peek（取栈顶元素不出栈）方法
                                              // 使用队列时，使用ArrayDeque的add（可能有异常）offer(不会有异常)和remove（可能有异常）poll(不会有异常)方法。
        //Stack<Object> stack = new Stack<>();
        int i = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度:");
        int n = scanner.nextInt();
        System.out.println("输入入栈数组内容:");
        int [] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        System.out.println("输入入栈数组内容:");
        int [] pop = new int[n];
        for (int i=0;i<n;i++){
            pop[i]= scanner.nextInt();
        }
        System.out.println(validateStackSequences(nums,pop));
    }
}

