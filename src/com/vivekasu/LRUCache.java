package com.vivekasu;

import java.util.HashMap;

public class LRUCache {

    class DListNode{

        DListNode next;
        DListNode prev;
        int key;
        int value;
    }

    DListNode head;
    DListNode tail;
    HashMap<Integer, DListNode> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DListNode();
        tail = new DListNode();
        head.prev = null;
        tail.next = null;
        head.next = tail;

    }

    public DListNode addNode(int key, int value){

        DListNode node = new DListNode();
        node.key = key;
        node.value = value;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        return node;

    }

    public void moveToHead(DListNode node){

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

    public DListNode popNode(){

        DListNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;

    }

    public void removeNode(DListNode node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public int get(int key) {

        if(cache.size()==0)
            return -1;

        DListNode node = cache.get(key);
        if(node==null)
            return -1;
        else{
            removeNode(node);
            moveToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        int size  = cache.size();
        if(cache.get(key)==null){
            DListNode node = addNode(key, value);
            cache.put(key, node);
            size++;
            if(size>capacity){
                DListNode delnode = popNode();
                cache.remove(delnode.key);
                size--;
            }

        }
        else{
            DListNode node = cache.get(key);
            if(node.value!=value){
                node.value = value;
            }
            removeNode(node);
            moveToHead(node);

        }
    }
}
