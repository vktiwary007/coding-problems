package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class isPalindromeLL {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node.val);
            node = node.next;
        }

        int end = list.size()-1;
        int start = 0;
        int count = 0;
        while(start<end && list.get(end--).equals(list.get(start++))){
            count++;
        }

        return count==(list.size()/2);

    }
}
