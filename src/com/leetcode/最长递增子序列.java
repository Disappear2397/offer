package com.leetcode;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/4/4 14:11
 */
public class 最长递增子序列{
    //求最长递增子序列的长度
    //动态规划 n^2  动态方程：dp[i]=max(dp[j])+1  其中0≤j<i且num[j]<num[i]
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];//dp 表示以第i个数字结尾的最长上升子序列的长度
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //更新长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    //贪心算法 二分查找  nlogn
    //d[i]表示长度为 i 的最长上升子序列的末尾元素的最小值,len 记录目前最长上升子序列的长度
/*    如果nums[i]>d[len] ，则直接加入到 d 数组末尾，并更新 len=len+1；
    否则，在 d 数组中二分查找，找到第一个比nums[i] 小的数d[k] ，并更新d[k+1]=nums[i]。*/

    public static int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] s = next.split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(lengthOfLIS2(arr));
    }
}
