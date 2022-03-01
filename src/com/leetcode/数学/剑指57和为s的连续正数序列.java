package com.leetcode.数学;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/14 21:32
 */


public class 剑指57和为s的连续正数序列{
    //双指针+滑动窗口
    public static int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;//等差数求和   （首项+末项）*len/2
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("请输入目标数");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String s = Arrays.deepToString(findContinuousSequence(a));//deepToString返回指定数组“深层内容”的字符串表示形式。
                                                                        // 如果数组包含作为元素的其他数组，则字符串表示形式包含其内容等。
                                                                    // 此方法是为了将多维数组转换字符串而设计的。
        System.out.println(s.toCharArray());
    }

}
