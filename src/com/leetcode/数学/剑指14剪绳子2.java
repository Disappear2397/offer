package com.leetcode.数学;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/14 16:09
 */
//在Ⅰ的基础上取模1e9+7（1000000007）   用%1000000007表示
public class 剑指14剪绳子2{
    public static int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(54));
    }
}
