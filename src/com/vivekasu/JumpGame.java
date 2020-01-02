package com.vivekasu;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int n = nums.length;

        if(n<2)
            return true;

        boolean[] dp = new boolean[n];

        dp[n-1] = true;
        int left = n-1;
        int curr = n-2;
        for(int i=n-2;i>=0;i--){

            int farthest = Math.min(n-1, nums[i]+i);

            if(farthest>=left ){
                dp[i] = true;
                left = i;
            }

        }

        return dp[0];

    }
}
