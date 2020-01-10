package com.vivekasu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {

    public boolean canCross(int[] stones) {

        HashMap<Integer, Set<Integer>> jumps = new HashMap<>();
        int n = stones.length;
        for(int i=0;i<n;i++){
            jumps.put(stones[i], new HashSet<Integer>());
        }


        jumps.get(stones[0]).add(0);
        if(stones[1]<=1)
            jumps.get(stones[1]).add(0);
        int prevJump = 1;

        for(int i=1;i<n;i++){

            int k = prevJump;
            if(jumps.get(stones[i]).size()<1)
                break;
            for(int j = k-1;j<=k+1;j++){

                if(j>0 && jumps.containsKey(stones[i]+j)){
                    jumps.get(stones[i]+j).add(stones[i]);
                    if(prevJump<j)
                        prevJump = j;

                }

            }


        }

        return jumps.get(stones[n-1]).size()>0;
    }
}
