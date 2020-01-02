package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class ReverseLLII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head==null)
            return head;
        int i=1;
        ListNode node = head;
        ListNode curr = null;
        while(i<m){
            curr = node;
            node = node.next;
            i++;
        }

        List<ListNode> reverse = reverseLL(node, n-m+1);
        if(curr==null)
            head = reverse.get(0);
        else
            curr.next = reverse.get(0);
        node.next = reverse.get(1);

        return head;

    }


    public List<ListNode> reverseLL(ListNode head, int l){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int i = 1;
        while(i<=l){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        List<ListNode> ans = new ArrayList<>();
        ans.add(prev);
        ans.add(curr);

        return ans;
    }
}
