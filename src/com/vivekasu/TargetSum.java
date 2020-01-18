package com.vivekasu;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        return findways(nums, 0, S);

    }


    public int findways(int[] nums, int ind, int target){

        if(ind==nums.length){
            return target==0?1:0;
        }

        return findways(nums, ind+1, target-nums[ind]) + findways(nums, ind+1, target+nums[ind]);
    }
}
