package com.vivekasu;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int sqN = (int)Math.sqrt(n) + 1;

        int[] sq = new int[sqN];

        for(int i=1;i<sqN;i++)
            sq[i] = i*i;

        for(int i=1;i<=n;i++){

            for(int j=1;j<sqN;j++){
                if(sq[j]>i)
                    break;
                else
                    dp[i] = Math.min(dp[i-sq[j]] + 1, dp[i]);
            }

        }

        return dp[n];

    }
}
