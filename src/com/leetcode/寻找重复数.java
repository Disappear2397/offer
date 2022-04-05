package com.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TransferQueue;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/3 19:56
 */
public class 寻找重复数{
    //二分查找 cnt 表示nums数组中小于等于i的数有多少个  不太好理解 时间复杂度高  时间：O(nlogn) 空间：O（1）
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r)/ 2;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {//说明重复数的值在[mid+1，r]之间
                l = mid + 1;
            } else {//说明重复数在[l，mid]之间
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    //快慢指针（最合适） 相当于环形链表2（找入环点）那题  整张图一定存在环，且我们要找到的target 就是这个环的入口   时间：O(n) 空间：O（1）
    /*先设置慢指针slow和快指针fast慢指针每次走一步，快指针每次走两步，根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，
    此时我们再将slow 放置起点 0，两个指针每次同时移动一步，相遇的点就是答案。  推导过程见142题环形链表2*/
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);//第一次相遇 fast走两步，slow走一步
        slow = 0;
        while (slow != fast) {//第二次相遇，fast和slow都走一步
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    //无脑set   空间之间都是O（n）
    public int findDuplicate2(int[] nums) {
        Set<Integer> pos = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!pos.add(nums[i])) return  nums[i];
        }
    return -1;
    }
}
