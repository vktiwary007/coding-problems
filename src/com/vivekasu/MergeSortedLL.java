package com.vivekasu;

public class MergeSortedLL {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        ListNode l6 = new ListNode(6);
        l5.next = l6;
        ListNode l8 = new ListNode(7);
        l6.next = l8;
        l8.next = new ListNode(8);
        ListNode l7 = reverseKGroupLast(l1,5);
        while(l7!=null){
            System.out.println(l7.val);
            l7 = l7.next;
        }

    }

    public static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null && l2==null)
            return null;
        else if(l1!=null && l2==null)
            return l1;
        else if(l1==null && l2!=null)
            return l2;

        ListNode newhead = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        if(tmp1.val<=tmp2.val){
            newhead = tmp1;
            tmp1 = tmp1.next;
        }
        else{
            newhead = tmp2;
            tmp2 = tmp2.next;
        }
        ListNode prev = newhead;
        while(tmp1!=null && tmp2!=null){
            if(tmp1.val<=tmp2.val){
                prev.next = tmp1;
                tmp1 = tmp1.next;
            }else{
                prev.next = tmp2;
                tmp2 = tmp2.next;
            }
            prev = prev.next;
        }

        if(tmp1!=null){
            prev.next = tmp1;
        }
        else{
            prev.next = tmp2;
        }

        return newhead;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null && l2==null)
            return null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int sum = 0;
        int carry = 0;
        if(tmp1!=null && tmp2!=null){
            sum = (tmp1.val + tmp2.val)%10;
            carry = (tmp1.val + tmp2.val)/10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        else if(tmp1==null && tmp2!=null){
            sum = tmp2.val%10;
            carry = tmp2.val/10;
            tmp2 = tmp2.next;
        }
        else if(tmp1!=null && tmp2==null){
            sum = tmp1.val%10;
            carry = tmp1.val/10;
            tmp2 = tmp1.next;
        }
        ListNode node = new ListNode(sum);
        ListNode prev = node;
        while(tmp1!=null && tmp2!=null){
            sum = (tmp1.val + tmp2.val+carry)%10;
            carry = (tmp1.val + tmp2.val+carry)/10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            ListNode newnode = new ListNode(sum);
            prev.next = newnode;
            prev = prev.next;
        }
        while(tmp1!=null){
            sum = (carry+tmp1.val)%10;
            carry = (carry+tmp1.val)/10;
            ListNode newnode = new ListNode(sum);
            prev.next = newnode;
            prev = prev.next;
        }
        while(tmp2!=null){
            sum = (carry+tmp2.val)%10;
            carry = (carry+tmp2.val)/10;
            ListNode newnode = new ListNode(sum);
            prev.next = newnode;
            prev = prev.next;
        }

        if(carry>0){
            ListNode newnode = new ListNode(carry);
            prev.next = newnode;
            prev = prev.next;
        }
        return node;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {



        if(head==null)
            return null;

        ListNode prev = null;
        ListNode newhead = null;
        int c = 0;
        ListNode curr = head;
        ListNode currhead ;
        ListNode prevhead = curr;
        while(curr!=null){

            ListNode tmpprevhead = null;
            for(int i=0;i<k && curr!=null ;i++){
                ListNode tmpnext = curr.next;

                curr.next = prev;
                prev = curr;
                curr = tmpnext;

                if(i==0){
                    tmpprevhead = prevhead;
                    prevhead = prev;
                }

                if(i==(k-1) || tmpnext==null){
                    currhead = prev;
                    tmpprevhead.next = currhead;
                }
            }

            c++;
            if(c==1){
                newhead = prev;
            }

            prev = null;
            if(curr==null){
                break;
            }

        }

        return newhead;
    }


    public static ListNode reverseKGroupLast(ListNode head, int k) {



        if(head==null)
            return null;


        ListNode prev = null;
        ListNode newhead = null;
        int c = 0;
        ListNode curr = head;
        ListNode currhead ;
        ListNode prevhead = curr;
        int len = 0;
        while(curr!=null){
            len++;
            curr = curr.next;
        }

        if(len<k)
            return head;
        curr = head;
        int countk = 0;
        while(curr!=null){

            ListNode tmpprevhead = null;
            for(int i=0;i<k && curr!=null ;i++){
                ListNode tmpnext = curr.next;
                countk++;
                curr.next = prev;
                prev = curr;
                curr = tmpnext;

                if(i==0){
                    tmpprevhead = prevhead;
                    prevhead = prev;
                }

                if(i==(k-1) || tmpnext==null){
                    currhead = prev;
                    tmpprevhead.next = currhead;
                }
            }

            c++;
            if(c==1){
                newhead = prev;
            }

            prev = null;
            if(curr==null || (len-c*k)<k){

                break;
            }

        }

        prevhead = newhead;
        int i = 0;
        while(prevhead!=null && i<c*k-1){
            prevhead = prevhead.next;
            i++;
        }

        prevhead.next = curr;


        return newhead;
    }


}
