package com.vivekasu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectCitiesMinCost {

    int[] union;
    byte[] rank;
    int connectedcomponents = 0;
    public void unionnodes(int a, int b){
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

    public int find(int a){

        while(a!=union[a]){
            union[a] = union[union[a]];
            a = union[a];
        }
        return a;
    }

    public boolean connected(int a, int b){
        return find(a)==find(b);
    }

    public int minimumCost(int N, int[][] connections) {


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
