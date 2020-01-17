package com.vivekasu;

public class LongestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        if(n<1)
            return 0;
        int[] dp = new int[n];
        int max = 1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int maxval = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval+1;

            max = Math.max(max, dp[i]);
        }

        return max;

    }
}
