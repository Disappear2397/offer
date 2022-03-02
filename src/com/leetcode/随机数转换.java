package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/2 14:13
 */
public class 随机数转换{
    public static int  random5(){
        int i = (int) (Math.random() * 5 + 1);//生成【1-5】  生成【0-5）：(int)Math.random()*5   0.0 =< Math.random < 1.0
        return i;
    }
    public static int  random25(){
        int val = 0;
        do {
            val = 5 * (random5() -1) +random5();
        }while (val > 25);
        return val;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(random25());
        }

    }

}
