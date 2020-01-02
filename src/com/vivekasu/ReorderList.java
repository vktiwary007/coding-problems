package com.vivekasu;

import java.util.Stack;

public class ReorderList {

    public void reorderList(ListNode head) {

        int l = getLength(head);
        if(l<=2)
            return;

        Stack<ListNode> stack = new Stack<>();

        setStack(head, stack);

        ListNode next = null;
        ListNode curr = head;
        head = curr;
        ListNode reverse = stack.pop();
        for(int i=0;i<l/2 && !stack.isEmpty();i++){

            next = curr.next;
            curr.next = reverse;
            curr = next;
            if(i==l/2-1)
                break;
            reverse.next = curr;
            reverse = stack.pop();

        }

        if(l%2!=0)
            reverse.next = stack.pop();

    }

    public int getLength(ListNode head){

        int l = 0;
        while(head!=null){
            l++;
            head = head.next;
        }

        return l;
    }

    public void setStack(ListNode head, Stack<ListNode> stack){

        while(head!=null){

            stack.push(new ListNode(head.val));
            head = head.next;
        }

    }
}
