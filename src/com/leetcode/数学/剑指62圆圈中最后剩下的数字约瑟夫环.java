package com.leetcode.数学;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/15 11:01
 */
public class 剑指62圆圈中最后剩下的数字约瑟夫环{

    //模拟做法 迭代
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i<n; i++){
            list.add(i);
        }
        int a = 0;
        while (n > 1){
            a = (a + m - 1) % n;
            list.remove(a);//默认索引删除
            n--;
        }
        return list.get(0);//默认索引提取

    }
    //约瑟夫环
    public int lastRemaining1(int n, int m) {
        int ans = 0;
        // 可以看作最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
