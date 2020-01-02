package com.vivekasu;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    HashMap<Node, Node> hm;
    public Node cloneGraph(Node node) {

        if(hm==null)
            hm = new HashMap<>();
        if(node==null)
            return node;

        if(hm.containsKey(node)){
            return hm.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        hm.put(node, clone);
        for(Node n: node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }
}
