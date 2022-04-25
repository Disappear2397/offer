package com.leetcode;

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
                if(fast == slow){//第一次相遇 fast走两步，slow走一步
                    //有环
                    //记住相遇点的指针，一个从相遇点开始，一个从头开始，相遇的地方就是环的入口点
                    // 因为此时从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离
                    ListNode tmp = head;
                    if(tmp == fast){//第二次相遇  ast和slow都走一步
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
