package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/14 14:47
 */
public class 判断一个数是不是整数{
    //考虑字母，整数上界，整数下界
    public static void main(String[] args) {
        String str = "-8888888888888888 123";
        String [] list = str.split(" ");
        String firstStr = list[0];
        if(isNumeric(firstStr)) {
            if(str.charAt(0) == '-')
                {
                    try{
                        System.out.println(Integer.parseInt(firstStr));
                    }catch (Exception e) { System.out.println(Integer.MIN_VALUE);
                    }
                    return;
                }
            try{
                System.out.println(Integer.parseInt(firstStr));
            }catch (Exception e)
            {
                System.out.println(Integer.MAX_VALUE);
            }return;
        }
        System.out.println(0);
    }
        //方法五：用 ascii 码
    public static boolean isNumeric(String str) {
        int begin = 0;
        if (str.charAt(0) == '-')
            begin = 1;
        for (int i = str.length(); --i >= begin; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)//0~9的ASCII值
                return false;
        }
        return true;
    }
}
