package com.vivekasu;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int prev = 0;
        for(int i=0;i<n;i++){
            while(i< n && nums[i]==0) i++;
            if(i<n)
                nums[prev++] = nums[i];
        }

        for(int i=prev;i<n;i++)
            nums[i] = 0;

    }
}
