package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/13 10:24
 */
public class 最小覆盖子串{
    /*滑动窗口的使用：分三种情况来移动窗口：（这里令当前窗口的左右边界分别为l，r，窗口的大小为winSize=r-l+1）
            1) 当winSize < t.size()  r++;  也就是窗口右边界向右移动
            2) 当winSize == t.size() :
                2.1) 当窗口中的字符已经符合要求了，直接返回return，已经找到了
	            2.2) 否则r++，窗口右边界向右移动
            3) 当winSize > t.size()
                3.1) 当窗口中的字符已经符合要求了，l++，窗口左边界向右移动
                3.2) 否则r++，窗口右边界向右移动*/
    public static String minWindow1(String s, String t) {
        // s字符串长度
        int sLen = s.length();
        // t字符串长度
        int tLen = t.length();
        // 如果s的长度小于t的长度直接返回空字符串
        if (sLen < tLen) return "";

        // 记录字符出现的次数
        int[] cnt = new int[58];//int类型定义的数组，初始化默认是0

        // 记录t的字符数
        int flag = 0;
        // 遍历t字符串
        for (int i = 0; i < tLen; i++) {
            --cnt[t.charAt(i) - 'A'];
            // 需要查找的总字符次数
            flag++;
        }

        // s的左指针：l s的右指针：r
        int l = 0;
        // begin（满足条件的最小字符串的开始位置），len（最小子串的长度）
        int begin = 0, len = Integer.MAX_VALUE;

        for (int r = 0; r < sLen; r++){

            // s串右指针索引下的字符，所对应的cnt的下标索引
            int indexR = s.charAt(r) - 'A';
            // 如果cnt[indexR]的值小于 0 时，说明是t中出现的字符
            if (cnt[indexR] < 0){
                // 找到一个字符，flag减一
                flag--;
            }
            // 字符出现加一
            ++cnt[indexR];

            // 当flag == 0时，说明已经完成匹配，需要求最短字符串情况
            // 当cnt大于0时，说明是可被剔除的字符，cnt值减一，左指针右移
            while (flag == 0 && cnt[s.charAt(l) - 'A'] > 0){
                --cnt[s.charAt(l) - 'A'];
                l++;
            }

            // 记录最短长度的已经匹配的子串
            if (flag == 0 && len > r - l){//len > r - l判断当前的最小覆盖字串是否比之前的最小覆盖字串短
                begin = l;
                len = r - l;
            }
        }
        return len > sLen ? "" : s.substring(begin, begin + len + 1);
    }
    public static String minWindow2(String s, String t) {
        Map<Character,Integer> window = new HashMap();  // 用来记录窗口中的字符和数量
        Map<Character,Integer> need = new HashMap();  // 需要凑齐的字符和数量
        // 构建need字符集
        for (int i = 0; i < t.length(); i++) {
            char needChar = t.charAt(i);
            need.put(needChar,need.getOrDefault(needChar,0)+1);
        }

        int left = 0,right = 0,valid = 0;
        // valid是用来记录窗口中满足need要求的字符和数量的数目，比如need中要求字符a数量为2，如果window中的a字符的数量等于了2，valid就＋1，反之-1
        int len = Integer.MAX_VALUE;  // 记录最小字串的长度
        int start = 0;  // 记录最小字串的起始位置
        while(right < s.length()){
            char addChar = s.charAt(right);  // 即将要加入window的字符
            window.put(addChar,window.getOrDefault(addChar,0) + 1);
            right++;
            // 如果加入的字符是need中要求的字符，并且数量已经达到了need要求的数量，则valid+1
            // 这里和下面都有个坑，window.get(addChar)和need.get(addChar)返回的都是对象，最好用.equals()方法比较大小
            if(need.containsKey(addChar) && window.get(addChar).equals(need.get(addChar))){
                valid++;
            }
            // 当window中记录的字符和数量满足了need中要求的字符和数量，考虑缩窗口 ,可能后面还有更符合要求的最短子串
            while(valid == need.size()){
                // 先判断当前的最小覆盖字串是否比之前的最小覆盖字串短
                if(right - left < len){  // 注意，这里上面已经对right实施了++操作，所以这里的长度不是right - left + 1
                    len = right - left ;
                    start = left;  // 如果最短，则记录下该最小覆盖字串的起始位置
                }
                char removeChar = s.charAt(left);
                // 开始缩减窗口，left右移，如果要从window删除的字符正好是need中需要的并且，数目也等于need中需要的数目，则删减后，该该字符要求的数量
                // 显然不满足need要求的数量，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次valid-1
                if(need.containsKey(removeChar) && window.get(removeChar).equals(need.get(removeChar))){
                    valid--;
                }
                window.put(removeChar,window.get(removeChar) - 1);
                left++;
            }

        }
        // 如果最小覆盖字串的长度相对于定义时没变，则t不包含s中所有的字符，返回"",如果长度改变过，说明存在这样的最小覆盖字串，直接输出。
        return len == Integer.MAX_VALUE? "" :s.substring(start,start+len);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个字符串:");
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(minWindow1(s,t));
    }
}
