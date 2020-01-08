package com.vivekasu;

public class RemoveElementLL {

    public ListNode removeElements(ListNode head, int val) {

        ListNode node = head;
        ListNode prev = null;

        while(node!=null){

            if(node.val==val){
                if(prev==null){
                    head = head.next;
                    node = head;
                }
                else{
                    prev.next = node.next;
                }
            }
            else{
                prev = node;
            }

            if(prev!=null)
                node = node.next;

        }

        return head;
    }
}
