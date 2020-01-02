package com.vivekasu;

import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {

        int n = nums.length;
        if(n<2)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, n+1);
        dp[n-1] = 1;

        for(int i=n-2;i>=0 ;i--){

            int farthest = Math.min(n-1, i+nums[i]);
            for(int j=i+1;j<=farthest;j++){

                if(farthest==n-1){
                    dp[i] = 1;
                    break;
                }
                else {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }

            }

        }

        return dp[0];

    }
}
