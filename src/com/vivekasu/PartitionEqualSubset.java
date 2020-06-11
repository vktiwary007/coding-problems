package com.vivekasu;

public class PartitionEqualSubset {

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        if(n<1)
            return true;

        int sum = 0;
        for(int s: nums){
            sum+=s;
        }

        if(sum%2!=0)
            return false;

        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0;i<n;i++){

            for(int j=target;j>=nums[i];j--){

                dp[j] = dp[j] | dp[j - nums[i]];

            }
        }


        return dp[target];
    }
}
