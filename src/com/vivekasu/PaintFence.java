package com.vivekasu;

public class PaintFence {

    public int numWays(int n, int k) {

        if(n<1)
            return 0;
        int[] ways = new int[n+1];

        int diff = k;
        int same = 0;
        ways[0] = 0;
        ways[1] = k;
        for(int i=2;i<n+1;i++){
            same = diff;
            diff = ways[i-1]*(k-1);
            ways[i] = same +diff;
        }

        return ways[n];
    }
}
