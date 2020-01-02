package com.vivekasu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Repairedges {

    public static void main(String[] args){

        int[][] edges = {{1,4},{4,5},{2,3}};
        int[][] newEddges = {{1,2,5},{1,3,6},{2,3,1}};
        //System.out.println(mincosttorepairedges(6, edges, newEddges));
        System.out.println(minimumCost(3, newEddges));
    }

    static int[] union;
    static byte[] rank;
    static int connectedcomponents = 0;
    public static void unionnodes(int a, int b){
        int parenta = find(a);
        int parentb = find(b);
        if(parenta!=parentb){
            if(rank[parenta]<rank[parentb]){
                union[parenta] = parentb;
            }
            else{
                union[parentb] = parenta;
                if(rank[parenta]==rank[parentb])
                    rank[parenta]++;
            }
            connectedcomponents--;
        }


    }

    public static int find(int a){

        while(a!=union[a]){
            union[a] = union[union[a]];
            a = union[a];
        }
        return a;
    }

    public static boolean connected(int a, int b){
        return find(a)==find(b);
    }

    public static int mincosttorepairedges(int n, int[][] edges, int[][] edgesToRepair){
        int cost = 0;
        union = new int[n+1];
        rank = new byte[n+1];
        for(int i=0;i<n+1;i++){
            union[i] = i;
        }
        connectedcomponents = n;
        HashMap<String,Integer> hm = new HashMap<>();
        PriorityQueue<int[]> edgecost = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]<o2[2])
                    return -1;
                if(o1[2]>o2[2])
                    return 1;
                return 0;
            }
        });

        for(int[] edgerepair: edgesToRepair){
            edgecost.add(edgerepair);
            hm.put(edgerepair[0]+"-"+edgerepair[1],edgerepair[2]);
        }

        for(int[] connect: edges){
            if(!hm.containsKey(connect[0]+"-"+connect[1])){
                unionnodes(connect[0], connect[1]);
            }
        }

        while(!edgecost.isEmpty()) {
            int[] repairedge = edgecost.poll();
            if (!connected(repairedge[0], repairedge[1])) {
                unionnodes(repairedge[0], repairedge[1]);
                cost = cost + repairedge[2];
            }

            if (connectedcomponents == 1)
                break;
        }

        return cost;
    }


    public static int minimumCost(int N, int[][] connections) {

        int cost = 0;
        union = new int[N+1];
        rank = new byte[N+1];
        for(int i=0;i<N+1;i++){
            union[i] = i;
        }
        connectedcomponents = N;
        PriorityQueue<int[]> edgecost = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]<o2[2])
                    return -1;
                if(o1[2]>o2[2])
                    return 1;
                return 0;
            }
        });

        for(int[] edgerepair: connections){
            edgecost.add(edgerepair);
        }

        int beforeconnected = connectedcomponents;
        while(!edgecost.isEmpty()){
            int[] repairedge = edgecost.poll();
            if(!connected(repairedge[0],repairedge[1])){
                unionnodes(repairedge[0],repairedge[1]);
                cost = cost  + repairedge[2];
            }
            if(connectedcomponents==1)
                break;
        }

        if(connectedcomponents!=1)
            return -1;

        return cost;
    }
}
