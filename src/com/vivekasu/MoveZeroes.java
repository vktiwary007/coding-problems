package com.vivekasu;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==0)
                count++;
        }

        int j = 0;
        for(int i=0;i<n;i++){

            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }

            if(j==(n-count))
                break;

        }

        for(int i=j;i<n;i++){
            nums[i] = 0;
        }

    }
}
