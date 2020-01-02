package com.vivekasu;

public class MissingNum {

    public int missingNumber(int[] nums) {

        int actualXOR = nums[0];
        int expectedXOR = 0;

        int n = nums.length;

        for(int i=1;i<n;i++){
            actualXOR = actualXOR^nums[i];
            expectedXOR = expectedXOR^i;
        }
        expectedXOR = expectedXOR^n;

        return actualXOR^expectedXOR;

    }
}
