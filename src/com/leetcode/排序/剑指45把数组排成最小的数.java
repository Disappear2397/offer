package com.leetcode.排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/1 9:58
 */
//直接修改sort内置函数参数或者修改快速排序
public class 剑指45把数组排成最小的数{
    public static String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i=0; i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s,(x, y) -> (x + y).compareTo(y + x));//(x + y).compareTo(y + x) 前减后（字符串相减）
                                                            //lambda表达式：(x, y)：参数定义     (x + y).compareTo(y + x)：执行代码
        /*compareTo：如果参数字符串等于此字符串，则返回值 0；
                    如果此字符串小于字符串参数，则返回一个小于 0 的值； ->降序
                    如果此字符串大于字符串参数，则返回一个大于 0 的值。  ->升序
        */
        StringBuilder builder = new StringBuilder();
        for(String a : s)
            builder.append(a);
        return builder.toString();
    }


    //修改快速排序
    public  static String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    static void  quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
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
        System.out.println(minNumber1(a));
    }

}
