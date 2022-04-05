package com.leetcode.括号题;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/29 11:34
 */
public class 有效的括号{
    //辅助栈 hashmap
    public static boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {//判断是三种右括号中的一种，是就开始匹配
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {//左括号（就是pair的value）入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    //辅助栈 if语句判断 这种更快更简单
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.peek())return false; //c!=stack.peek()可以改为stack.pop，就不用再pop一次（pop返回的是值）
            else stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.next();
        System.out.println(isValid2(s));
    }
}
