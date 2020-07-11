package com.vivekasu;

public class FlattenDLL {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        if(head==null)
            return head;

        Node node = head;
        flattenNode(node);

        return head;

    }

    public Node flattenNode(Node node){

        if(node==null)
            return node;
        Node prev = node;

        while(node!=null){

            prev = node;

            if(node.child==null){
                node = node.next;
                continue;
            }

            Node next = node.next;
            node.next = node.child;
            node.child.prev = node;

            Node tail = flattenNode(node.child);
            node.child = null;
            if(next!=null){
                tail.next = next;
                next.prev = tail;
                node = next;
            }
            else{
                node = tail;
            }


        }

        return prev;
    }
}
