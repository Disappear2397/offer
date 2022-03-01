package com.leetcode;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/9 15:41
 */
public class 最大子数组和{
    //简单动态规划
    public  int maxSubArray(int[] nums){
        int pre=0,max=nums[0];
        for(int i:nums) {
            pre = Math.max(pre+i, i);//验证当前序列的最大和
            max = Math.max(pre, max);//验证当前序列和之前序列的最大和
        }
        return max;
    }
}
