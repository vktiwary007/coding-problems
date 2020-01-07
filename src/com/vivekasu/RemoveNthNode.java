package com.vivekasu;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int l = getLengthLL(head);
        int k = l-n+1;
        int i = 0;
        ListNode node = head;
        ListNode prev = null;
        while(i<k && node!=null){

            if(i==k-1){

                if(prev==null)
                    head = head.next;
                else{
                    prev.next = node.next;
                }
                break;
            }
            else{
                prev = node;
            }

            i++;
            node = node.next;
        }


        return head;

    }


    public int getLengthLL(ListNode head){

        int i=0;
        while(head!=null){
            i++;
            head = head.next;
        }

        return i;
    }
}
