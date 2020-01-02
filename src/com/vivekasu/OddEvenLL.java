package com.vivekasu;

public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {

        if(head==null)
            return head;

        ListNode curr = head;
        ListNode even = null;
        ListNode odd = null;
        ListNode evenhead = null;

        while(curr!=null && curr.next!=null){
            if(odd==null){
                odd = curr;
                head = odd;
            }
            else{
                odd.next = curr;
                odd = odd.next;
            }

            if(even==null){
                even = curr.next;
                evenhead = even;
            }
            else{
                even.next = curr.next;
                even = even.next;
            }
            curr = curr.next.next;

        }

        if(curr!=null){
            if(odd==null)
                return head;
            odd.next = curr;
            odd = odd.next;
        }

        even.next = null;
        odd.next = evenhead;
        return head;
    }
}
