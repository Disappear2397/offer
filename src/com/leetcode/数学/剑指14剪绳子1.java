package com.leetcode.数学;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/14 16:09
 */
public class 剑指14剪绳子1{
    //数学推导1  Math.pow(底数,几次方)
    public static int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }


    //数学推导2  迭代
    public static int cuttingRope2(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        //if(n == 4) return 4; 不用考虑4的情况 4的结果就是4
        int sum = 1;
        while (n > 4){
            sum*=3;
            n-=3;
        }
        return sum*n;
    }
    public static void main(String[] args) {
        System.out.println(cuttingRope2(54));
    }
}
