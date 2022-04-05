package com.leetcode.括号题;

import javax.sound.midi.spi.SoundbankReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/2 10:06
 */
public class 最长有效括号{
    //栈实现    求有效的括号对数
    public static int longestValidParentheses1(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);//初始化栈底
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);//入栈的是下标
            } else {
                stack.pop();
                if (stack.isEmpty()) {//出栈以后，栈为空让当前下标进栈，始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());//栈里的是对应下标
                }
            }
        }
        return max;
    }
    //动态规划  不易懂
    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];//dp[i] 表示以下标i字符结尾的最长有效括号的长度
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;//确定i是否能够移动到前一组符号组
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//当前下标前一位是），且前面存在（
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    //i - dp[i - 1]) >= 2 确定i是否能够移动到前一组符号组 如：（（）（））
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    //不需要额外的空间  left right两个计数器从左至右依次计数 再从右至左依次计数
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {//从左至右依次计数
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) { //当right计数器比left计数器大时，我们将 left 和 right 计数器同时变回 0
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {//从右至左依次计数
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) { //当left计数器比right计数器大时，我们将 left 和 right 计数器同时变回 0
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入括号字符串：");
        String next = scanner.next();
        System.out.println(longestValidParentheses1(next));
    }

}
