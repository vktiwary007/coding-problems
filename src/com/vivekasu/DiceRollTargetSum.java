package com.vivekasu;

public class DiceRollTargetSum {

    public int numRollsToTarget(int d, int f, int target) {

        int[][] ways = new int[d+1][target+1];
        int mod = 1000000007;
        ways[0][0] = 1;
        for(int i=1;i<=d;i++){

            for(int j=0;j<=target;j++){

                for(int k = 1;k<=f;k++){

                    if(j-k>=0){
                        ways[i][j] = (ways[i][j] + ways[i-1][j-k])%mod;
                    }

                }
            }
        }

        return  ways[d][target];
    }
}
