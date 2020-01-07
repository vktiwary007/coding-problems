package com.vivekasu;

import java.util.HashMap;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, ListNode> pos = new HashMap<>();
        ListNode node = head;
        int i = 0;
        while(node!=null){

            if(!pos.containsKey(node))
                pos.put(node, node);
            else
                return pos.get(node);

            i++;
            node = node.next;
        }


        return null;

    }
}
