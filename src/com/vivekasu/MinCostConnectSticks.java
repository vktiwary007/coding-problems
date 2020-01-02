package com.vivekasu;

import java.util.PriorityQueue;

public class MinCostConnectSticks {

    public int connectSticks(int[] sticks) {

        if(sticks.length<1)
            return 0;

        int mincost = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=0;i<sticks.length;i++){
            que.add(sticks[i]);
        }
        int prevsum = 0;
        while(que.size()!=1){
            int x1 = que.poll();
            int x2 = que.poll();
            prevsum = mincost;
            mincost = prevsum+x1+x2;
            que.add(x1+x2);
        }
        //mincost = prevsum + que.poll();
        return mincost;
    }
}
