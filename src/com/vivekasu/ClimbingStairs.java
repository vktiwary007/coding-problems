package com.vivekasu;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n<=1)
            return 1;
        int[] ways = new int[n+1];

        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for(int i=3;i<n+1;i++){
            ways[i] = ways[i-2] + ways[i-1];
        }

        return ways[n];

    }
}
