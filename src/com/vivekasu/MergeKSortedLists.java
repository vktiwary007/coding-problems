package com.vivekasu;

import java.util.PriorityQueue;

public class MergeKSortedLists {

   /**
     * Definition for singly-linked list.*/
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode mergeKLists(ListNode[] lists) {

        /*Comparator<ListNode> queOrder = (s1, s2) -> {
            return s1.val - s2.val;
        };*/

        PriorityQueue<ListNode> kNodeQue = new PriorityQueue<>((a, b)->a.val-b.val);
        int n = lists.length;
        for(int i=0;i<n;i++){
            if(lists[i]!=null)
                kNodeQue.add(lists[i]);
        }
        ListNode head = null;
        ListNode tmp = head;
        while(!kNodeQue.isEmpty()){

            ListNode node = kNodeQue.poll();

            if(head==null){
                head = node;
                tmp = node;
            }
            else{
                tmp.next = node;
                tmp = tmp.next;
            }
            node = node.next;
            if(node!=null)
                kNodeQue.add(node);

        }

        return head;

    }
}
