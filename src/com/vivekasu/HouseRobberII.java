package com.vivekasu;

public class HouseRobberII {

    int[] nums;
    public int rob(int[] nums) {

        int n = nums.length;
        if(n<1)
            return 0;
        if(n<2)
            return nums[0];
        int amount  = 0;
        this.nums = nums;
        amount = Math.max(calculateAmount(0,n-2),calculateAmount(1,n-1));
        return amount;
    }

    public int calculateAmount(int start, int end){

        if(start>=end)
            return nums[start];
        int n = end - start +1;
        int[] sum = new int[n];

        sum[0] = nums[start];
        sum[1] = Math.max(nums[start+1],sum[0]);

        for(int i=2,j=start+2;i<n && j<end+1;i++,j++){

            sum[i] = Math.max(nums[j]+sum[i-2], sum[i-1]);
        }


        return sum[n-1];
    }
}
