package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSet {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        if(n<1)
            return ans;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre,-1);
        int max = 0;
        int index = -1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){

                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        pre[i] = j;
                    }

                }

            }

            if(dp[i]>max){
                max = dp[i];
                index = i;
            }
        }

        while(index!=-1){
            ans.add(nums[index]);
            index = pre[index];
        }

        return ans;
    }
}
