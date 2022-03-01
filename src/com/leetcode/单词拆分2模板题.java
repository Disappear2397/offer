package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/30 11:29
 */
//模板题
    //回溯 自顶向下
public class 单词拆分2模板题{
    static List<String> res = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s,wordDict,new ArrayList<>(),0);
        return res;
    }
    public static void dfs(String s,List<String> wordDict,List<String> path,int index){
        if(index==s.length()){
            res.add(new String(String.join(" ",path)));//第一个参数表示连接的符号，第二个参数表示被连接的数组，也可以是集合、字符串、列表
            //new String()可以删除不用
            return;
        }
        for(int i=index;i<=s.length();i++){
            if(wordDict.contains(s.substring(index,i))){//将不可以拆分的情况进行剪枝
                path.add(s.substring(index,i));
                dfs(s,wordDict,path,i);
                path.remove(path.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符串:");
        String s = scanner.next();
        System.out.println("输入字符串列表：");
        String[] word = scanner.next().split(",");
        List<String> wordDict = new LinkedList<>();
        for (int i = 0; i < word.length; i++) {
            wordDict.add(word[i]);
        }
        System.out.println(wordBreak(s,wordDict));
    }
}
