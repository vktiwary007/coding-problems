package com.vivekasu;

import java.util.Arrays;
import java.util.HashSet;

public class MinTicketCosts {

    public int mincostTickets(int[] days, int[] costs) {

        int l = days.length;
        int[] mincost = new int[days[l-1]+1];
        int n = mincost.length;

        HashSet<Integer> daySet = new HashSet<>();
        for(int i=0;i<days.length;i++){
            daySet.add(days[i]);
        }
        Arrays.fill(mincost, Integer.MAX_VALUE);
        mincost[0] = 0;
        mincost[days[0]] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        int[] pass = {1,7,30};
        for(int i=1;i<n;i++){
            if(daySet.contains(i)){
                for(int j=0;j<pass.length;j++){
                    if(i>=pass[j]){
                        mincost[i] = Math.min(mincost[i-pass[j]] + costs[j], mincost[i]);
                    }
                    else{
                        mincost[i] = Math.min(costs[j], mincost[i]);
                    }
                }
            }
            else
                mincost[i] = mincost[i-1];

        }

        return mincost[n-1];

    }
}
