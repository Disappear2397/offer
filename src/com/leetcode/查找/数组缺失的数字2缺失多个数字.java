package com.leetcode.查找;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/25 14:28
 */
public class 数组缺失的数字2缺失多个数字{
    //set去重
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            set.add(nums[i]);//去重
        }
        for (int i = 1; i <= nums.length; i++) {
            if(set.add(i)){//有重复返回false 没重复返回ture,没重复的数就是缺失的数
                res.add(i);
            }
        }
        return res;
    }
    //数组代替set 遍历nums，  较难理解
    // 每遇到一个数x，就让nums[x−1]增加n。由于nums 中所有数均在[1,n]中，增加以后，这些数必然大于n。
    // 最后我们遍历nums，若nums[i]未大于n，就说明没有遇到过数i+1。这样我们就找到了缺失的数字

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n; //得到num值对应的下标
            nums[x] += n;   //num-1下标位置的数+n放入nums数组中
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                //因为值是[1,n]而第一个for循环经过if判断后筛选得到
                //的是有问题的下标即从0开始但值从1，所以下面用i+1
                ret.add(i + 1);//i位置上的值i+1未曾出现过
            }
        }
        return ret;
    }
}
