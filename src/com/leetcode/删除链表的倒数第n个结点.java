package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LJ
 * @version 1.0
 * @date 2021/11/27 21:45
 */
//双指针
public class 删除链表的倒数第n个结点{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        // 如果快指针走到了最后说明删除的是第一个节点,就返回head.next就好
        if(cur ==null) return head.next;
        // 使得pre每次都是在待删除的前一个节点, 所以要先让cur先走一步
        cur = cur.next;
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
    //伪头结点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
    public static void main(String[] args) {
        ListNode res = new ListNode(1);
        res.next = new ListNode(2);
        res.next.next= new ListNode(3);
        res.next.next.next = new ListNode(4);

        int n = 1;
        System.out.println(removeNthFromEnd(res,n));
    }
}
