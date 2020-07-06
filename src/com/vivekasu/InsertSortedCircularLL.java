package com.vivekasu;

public class InsertSortedCircularLL {

    public Node insert(Node head, int insertVal) {

        if(head==null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node node = head.next;
        Node newNode = new Node(insertVal);
        Node prev = head;
        boolean isInsert = false;
        while(node!=head){

            if(prev.val<=insertVal && insertVal<=node.val){
                isInsert = true;
            }
            else if(prev.val>node.val){

                if(insertVal>prev.val || insertVal<node.val)
                    isInsert = true;
            }

            if(isInsert){
                newNode.next = node;
                prev.next = newNode;
                return head;
            }

            prev = node;
            node = node.next;

        }
        newNode.next = node;
        prev.next = newNode;

        return head;

    }
}
