package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/19 16:15
 */
public class 回文链表{
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}//如果你创造了一个带有参数的构造方法，无参数的构造方法是默认的，那么无参的构造方法必须显式的写出来，否则会编译失败
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //判断是不是回文链表
    //法1.将链表复制到数组中然后用双指针,见力扣第234题
    //法2.快慢指针
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {//链表翻转
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {//找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
