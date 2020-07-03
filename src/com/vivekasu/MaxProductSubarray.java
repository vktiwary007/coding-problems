package com.vivekasu;

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int negProd = nums[0];
        int posProd = nums[0];
        for(int i=1;i<nums.length;i++){

            if(nums[i]<0){
                int temp = posProd;
                posProd = negProd;
                negProd = temp;
            }

            posProd = Math.max(nums[i], nums[i]*posProd);
            negProd = Math.min(nums[i], nums[i]*negProd);
            maxProd = Math.max(maxProd, posProd);

        }

        return maxProd;

    }
}
