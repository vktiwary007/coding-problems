package com.vivekasu;

public class MaxStack {

    class Node{

        int val;
        Node next;
        Node max;

        public Node(int val){
            this.val = val;
        }
    }

    Node head;
    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {

        if(head==null){
            head = new Node(x);
            head.max = new Node(x);
        }
        else{
            Node node = new Node(x);
            if(x>head.max.val){
                node.max = new Node(x);
                head.max = node.max;
            }
            else{
                node.max = head.max;
            }
            node.next = head;
            this.head = node;
        }

    }

    public int pop() {
        int val = head.val;
        int headval = head.max.val;
        head = head.next;
        if(headval==val){
            updateMax();
        }
        return val;

    }

    public void updateMax(){
        Node node = head;
        int newmax = Integer.MIN_VALUE;
        while(node!=null){
            if(node.val>newmax)
                newmax = node.val;
            node = node.next;
        }

        node = head;
        Node newmaxnode = new Node(newmax);
        while(node!=null){
            node.max = newmaxnode;
            node = node.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int peekMax() {
        return head.max.val;
    }

    public int popMax() {
        int maxval = head.max.val;
        Node node = head;
        Node prev = null;
        while(node!=null){
            if(node.val==maxval){
                if(prev==null){
                    head = node.next;
                }
                else{
                    prev.next = node.next;
                }
                break;
            }
            prev = node;
            node = node.next;
        }

        updateMax();

        return maxval;
    }
}
