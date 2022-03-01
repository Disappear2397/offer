package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/14 20:08
 */
public class 计算根号2{
    //二分法
    public static double squareTwo(){
        final double  frequency = 0.00000000001;
        double l = 1;
        double h = 2;
        while(h - l > frequency){
            double mid = (h + l) / 2.0;
            if(mid * mid > 2)
                h = mid;
            else
                l = mid;
        }
        String s = l + "";
        return Double.parseDouble(s.substring(0,12));
    }
    //牛顿迭代  x(n+1)=0.5*(x(n)+num/x(n))
    public static double squareTwo2(){
        final double  frequency = 0.00000000001;
        double result = 1.5d;
        double last = 1.6d;
        while(last - result > frequency){
            last = result;
            result = (result + 2.0 / result) / 2;
        }
        String s = result + "";
        return Double.parseDouble(s.substring(0,12));
    }
//    //递归
//    public static double SprtFunction2(double left , double right , double target) {
//        double mid = (left + right) / 2 ;
//        if(mid - left < 0.00001) {
//            return mid ;
//        }
//        if (mid * mid > target) {
//            return SprtFunction2(left , mid , target) ;
//        } else {
//            return SprtFunction2(mid , right , target) ;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(squareTwo2());
        System.out.println(squareTwo());
        //System.out.println(SprtFunction2(1.4,1.5,2));
    }
}
