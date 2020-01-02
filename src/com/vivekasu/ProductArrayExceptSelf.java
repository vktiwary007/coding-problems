package com.vivekasu;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] op = new int[n];
        int[] left =  new int[n];
        int[] right = new int[n];
        left[0] = 1;
        left[1] = nums[0];
        for(int i=2; i<n ;i++){
            left[i] = nums[i-1]*left[i-1];
        }
        right[n-1] = 1;
        right[n-2] = nums[n-1];
        for(int i=n-3; i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }

        for(int i=0;i<n;i++){
            op[i] = left[i]*right[i];
        }

        return op;
    }
}
