package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/23 11:30
 */
public class 最长连续序列有时间复杂度要求{
    //要求时间复杂度为O（n）  sort（）的时间复杂度是nlogn
    //Set集合不允许包含相同的元素，如果试图把两个相同元素加入同一个Set集合中，则添加操作失败，add()方法返回false，且新元素不会被加入
    //所以使用哈希表hashset去重

    //向两边搜索
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;//注意初始值，后面不用+1了
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
    //官方单边搜索 相当于向右搜索（数字从小到大搜索）
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
