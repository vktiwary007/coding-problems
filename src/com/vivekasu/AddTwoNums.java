package com.vivekasu;

public class AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = null;
        ListNode node = head;
        ListNode prev = null;
        ListNode h1 = reverseList(l1);
        ListNode h2 = reverseList(l2);
        int sum = 0, carry = 0;
        while(h1!=null || h2!=null){

            int x1 = h1!=null?h1.val:0;
            int x2 = h2!=null?h2.val:0;

            sum = carry+x1+x2;
            carry = sum/10;

            ListNode newNode = new ListNode(sum%10);
            if(head==null){
                head = newNode;
                node = head;
            }
            else{
                node.next = newNode;
            }

            if(node.next!=null)
                node = node.next;
            if(h1!=null)
                h1 = h1.next;
            if(h2!=null)
                h2 = h2.next;

        }

        if(carry>0){
            ListNode newNode = new ListNode(carry);
            node.next = newNode;
            node = node.next;
        }


        return reverseList(head);
    }


    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return prev;
    }
}
