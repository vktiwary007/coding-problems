package com.vivekasu;

import java.util.HashMap;

public class CopyLL {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    HashMap<Node, Node> visited;
    public Node copyRandomList(Node head) {
        visited = new HashMap<>();

        return copyList(head);
    }


    public Node copyList(Node node){

        if(node==null)
            return node;

        if(visited.containsKey(node))
            return visited.get(node);

        Node cloneNode = new Node(node.val, null, null);
        visited.put(node, cloneNode);
        cloneNode.next = copyList(node.next);
        cloneNode.random = copyList(node.random);
        return cloneNode;

    }
}
