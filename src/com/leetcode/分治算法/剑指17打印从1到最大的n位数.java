package com.leetcode.分治算法;

import java.util.Arrays;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/22 10:17
 */
public class 剑指17打印从1到最大的n位数{
    //若不考虑大数问题，则十分简单一个从1到最大数的循环即可。 若考虑大数问题，则首先需要将数字转成字符串避免溢出，然后全排列字符串的第0位到第n-1位。
    // 存储结果时需去掉字符串前几位的0(0099没有意义，应为99)再放入结果
    //要求输出 int 类型数组。为运行通过 ，可在添加数字字符串 s 前，将其转化为 int 类型
    static int[] res;
    static int nine = 0, count = 0, start, n;//数字各位中 9 的数量为 nine
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static int[] printNumbers(int n) {
        剑指17打印从1到最大的n位数.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    static void dfs(int x) {
        if(x == n) {// 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start);//这样可以删除高位多余的0
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

//返回string类型的
//    StringBuilder res;
//    int nine = 0, count = 0, start, n;
//    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//    public String printNumbers(int n) {
//        this.n = n;
//        res = new StringBuilder();
//        num = new char[n];
//        start = n - 1;
//        dfs(0);
//        res.deleteCharAt(res.length() - 1);//删除最后一个“，”
//        return res.toString();
//    }
//    void dfs(int x) {
//        if(x == n) {
//            String s = String.valueOf(num).substring(start);
//            if(!s.equals("0")) res.append(s + ",");
//            if(n - start == nine) start--;
//            return;
//        }
//        for(char i : loop) {
//            if(i == '9') nine++;
//            num[x] = i;
//            dfs(x + 1);
//        }
//        nine--;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}

