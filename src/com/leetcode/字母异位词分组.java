package com.leetcode;

import java.util.*;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/12/9 15:06
 */
public class 字母异位词分组{
    //哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);//对每一个字符串排序
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());//获取map中的value集合
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串数组：");
        String s = scanner.next();
        String[] arr = s.split(",");
        System.out.println(groupAnagrams(arr));
    }

}
