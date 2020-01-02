package com.vivekasu;

import java.util.HashMap;

public class NumDiceRolls {

    HashMap<String, Integer> hm = new HashMap<>();
    int mod = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {

        if(d<0 || target<0)
            return 0;

        if(d==0 && target==0){
            return 1;
        }
        String key = "d"+d+"t"+target;

        if(hm.containsKey(key))
            return hm.get(key);


        int numways = 0;
        for(int i=1;i<=f;i++){

            if(i>target)
                break;

            numways = (numways + numRollsToTarget(d-1,f, target-i))%mod;

        }

        hm.put(key,numways);

        return numways%mod;

    }
}
