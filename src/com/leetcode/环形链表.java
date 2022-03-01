package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/1/5 20:33
 */
public class 环形链表{
    //快慢指针，fast指针每次移动两个节点，slow指针每次移动一个节点，
    // 如果 fast 和 slow指针在途中相遇（相当于fast在一步一步追slow） ，说明这个链表有环
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null ) return  false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    //或者用hashset
    // 调用HashSet的add方法实质上是调用HashMap的put方法，map是全局，变量它指向的是在创建HashSet对象时创建的HashMap对象。
    // 如果put方法返回值为null则add方法返回true，证明添加成功；如果put方法返回值非null则add方法返回false，证明添加失败。
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) { //add返回值是false说明已有该元素
                return true;
            }
            head = head.next;
        }
        return false;
    }


}
