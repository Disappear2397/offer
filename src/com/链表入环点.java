package com;

/**
 * @author LJ
 * @version 1.0
 * @date 2022/3/2 15:22
 */
public class 链表入环点{
    class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
        public ListNode detectCycle(ListNode head) {
            if((head == null) || (head.next == null)){
                return null;
            }
            //使用快慢指针，若有环，相遇，否则无环
            ListNode fast = head;
            ListNode slow = head;
            while((fast != null) && (fast.next != null)){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    //有环
                    //记住相遇点的指针，一个从相遇点开始，一个从头开始，相遇的地方就是环的入口点
                    ListNode tmp = head;
                    //假设链表的开始就是入口点
                    //如果链表的开始是入口点，最后一定在开始的位置相遇
                    //因为fast是slow的两倍，当fast走了一圈的时候,slow走半圈，最后在fast走两圈，slow走一圈的位置相遇
                    if(tmp == fast){
                        return fast;
                    }
                    while(true){
                        fast = fast.next;
                        tmp = tmp.next;
                        if(fast == tmp){
                            break;
                        }
                    }
                    return fast;
                }
            }
            return null;
        }


}
