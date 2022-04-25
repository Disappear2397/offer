package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/1/5 20:52
 */
public class 环形链表2{
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  //快慢指针，纯数学计算 较难见精选答案
  public ListNode detectCycle1(ListNode head) {
      ListNode fast = head, slow = head;
      while (true) {//第一次相遇 fast走两步，slow走一步
          if (fast == null || fast.next == null) return null;
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) break;
      }
      fast = head;
      while (slow != fast) {//第二次相遇，fast和slow都走一步，此时从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离
          slow = slow.next;
          fast = fast.next;
      }
      return fast;
  }
  //hashset较容易，但是太慢
    public ListNode detectCycle2(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

}
