package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class ReverseKNodesLL {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode prev = null;
        ListNode node = head;
        ListNode curr = head;
        int len = getLLLength(head);
        int iter = len/k;
        int i=1;
        while(node!=null && i<=iter){

            List<ListNode> reverseK = reverseLL(node, k);
            if(prev==null)
                head = reverseK.get(0);
            else{
                prev.next = reverseK.get(0);
            }

            prev = node;
            node.next = reverseK.get(1);
            node = reverseK.get(1);
            i++;
        }

        return head;
    }

    public int getLLLength(ListNode node){

        if(node==null)
            return 0;
        ListNode curr = node;
        int l = 0;
        while(curr!=null){
            curr = curr.next;
            l++;
        }

        return l;
    }

    public List<ListNode> reverseLL(ListNode node, int k){

        ListNode curr = node;
        ListNode next = node.next;
        ListNode prev = null;
        int i=1;
        while(i<=k){
            if(curr==null)
                break;
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
