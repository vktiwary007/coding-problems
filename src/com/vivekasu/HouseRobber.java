package com.vivekasu;

public class HouseRobber {

    public int rob(int[] nums) {


        int n = nums.length;
        if(n<1)
            return 0;
        int[] money = new int[n];

        money[0] = nums[0];
        if(n<2)
            return nums[0];
        money[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++){

            money[i] = Math.max(nums[i]+money[i-2], money[i-1]);
        }

        return money[n-1];
    }
}
