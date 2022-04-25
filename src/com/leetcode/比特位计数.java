package com.leetcode;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/10 18:30
 */
public class 比特位计数{
    //计算从 0 到 n 的每个整数的二进制表示中的 1 的数目
    public static int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);//x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0
            ones++;
        }
        return ones;
    }
    //动态规划  最高有效位
    public static int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        // bits[0] = 0; 可不加
        int highBit = 0;//highBit 表示当前的最高有效位
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {//判断一个正整数是不是2的整数次幂,等于0就是2的整数次幂
                highBit = i;//更新当前的最高有效位
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(Arrays.toString(countBits2(i)));
    }

}
