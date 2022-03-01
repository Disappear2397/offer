package com.leetcode.位运算;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/9 21:44
 */
//本题与137只出现一次的数字2 一模一样
public class 剑指56数组中数字出现的次数2{
    //用map（getOrDefault和map.keySet用法）     前一题也可以用map
    public static int singleNumbermap(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int a = map.getOrDefault(nums[i], 0);
            map.put(nums[i], a + 1);//put会重写之前key的value值
        }
        for (Integer b : map.keySet()) {
        //对于keySet其实是遍历了2次，一次是转为iterator，一次就从hashmap中取出key所对于的value。
            // 而entryset只是遍历了第一次，他把key和value都放到了entry中，所以就快了。
            if(map.get(b) == 1) return b;
        }
        return -1;
    }
    //用map (containsKey,entrySet方法)
    public int singleNumbermap1(int[] nums) {
        //统计各个数字出现的次数，键为数字，值为出现的次数
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
                continue;
            }
            map.put(i,map.get(i)+1);
        }
        //遍历map中的键值对，查看值出现次数为1的键，即为答案
        int result = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    //位运算 状态自动机 看不懂
    public static int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;  //~非运算就是反码加1
        }
        return ones;
    }
    //位运算 遍历统计
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;// 更新第 j 位   &：按位与 都为1时结果才为1
                num >>>= 1;//第 j 位 --> 第 j + 1 位
            }
        }
        //通过以上方法可记录所有数字的第j个二进制位的 1的出现次数。

        //利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res上
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;// 左移 1 位
            res |= counts[31 - i] % m;// 恢复第 i 位的值到 res
        }
        return res;
    }
    //依次确定每一个二进制位
    //答案的第 i 个二进制位就是数组中所有元素的第 i 个二进制位之和除以 3 的余数
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i); // 恢复第 i 位的值到 res
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a ={3,4,3,3};
        System.out.println(singleNumber1(a));
    }
}
