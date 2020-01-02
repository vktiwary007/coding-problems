package com.vivekasu;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        int len = getListLength(head);
        if(len<1)
            return head;

        int i = 0;
        if(k>len)
            k = k%len;
        if(i==k || i==(len-k))
            return head;
        ListNode node = head;
        ListNode prev = null;
        while(i!=(len-k)){
            prev = node;
            node = node.next;
            i++;
        }

        ListNode tmp = node;
        ListNode prev1 = node;
        while(tmp!=null){
            prev1 = tmp;
            tmp = tmp.next;
        }

        prev1.next = head;
        head = node!=null?node:head;
        if(prev!=null)
            prev.next = null;

        return head;
    }


    public int getListLength(ListNode head){

        if(head==null)
            return 0;
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }

        return len;
    }
}
