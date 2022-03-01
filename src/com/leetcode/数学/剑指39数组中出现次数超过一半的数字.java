package com.leetcode.数学;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/13 21:39
 */
public class 剑指39数组中出现次数超过一半的数字{
    //map
    public static Map<Integer, Integer> countNums(int[] nums){
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            if (!count.containsKey(num)){
                count.put(num,1);
            }else {
                count.put(num,count.get(num)+1);
            }
        }
        return count;
    }
    public static int majorElement(int[] nums){
        Map<Integer, Integer> count = countNums(nums);
        Map.Entry<Integer,Integer> majorityEntry = null;
        for (Map.Entry<Integer,Integer> entry :count.entrySet()){
            if(majorityEntry == null || entry.getValue()>majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    //摩尔投票法
    public static int majorElement1(int[] nums) {

        //摩尔投票
        int count = 0;
        Integer card = null;
        for(int num:nums){
            if(count == 0) card = num;
            count += (card == num)?1:-1;
        }
        return card;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意个数字：");
        String str = scanner.next();
        String[] arr = str.split(",");
        int[] a = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(majorElement1(a));
    }
}
