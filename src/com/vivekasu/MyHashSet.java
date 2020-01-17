package com.vivekasu;

public class MyHashSet {

    class Node{

        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    Node[] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new Node[2069];
    }

    public void add(int key) {

        int index = key%2069;
        Node head = hashset[index];
        if(head==null){
            head = new Node(key);
            hashset[index] = head;
            return;
        }
        boolean found = false;
        Node prev = null;
        while(head!=null){
            if(head.val==key){
                found = true;
                break;
            }
            prev = head;
            head  = head.next;
        }

        if(!found){
            Node node = new Node(key);
            prev.next = node;
        }
    }

    public void remove(int key) {
        int index = key%2069;

        Node head = hashset[index];
        Node prev = null;
        while(head!=null){
            if(head.val==key){
                if(prev==null){
                    head = head.next;
                    hashset[index] = head;
                }
                else{
                    prev.next = head.next;
                }

                return;
            }

            prev = head;
            head = head.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%2069;

        Node head = hashset[index];

        while(head!=null){
            if(head.val==key){
                return true;
            }

            head = head.next;
        }


        return false;
    }
}
