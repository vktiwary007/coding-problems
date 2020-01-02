package com.vivekasu;

public class ReverseLL {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = head;

        while(curr!=null){
            ListNode tmp = curr;
            nxt = curr.next;
            tmp.next = prev;
            prev = tmp;
            curr  = nxt;
        }

        return prev;

    }
}
