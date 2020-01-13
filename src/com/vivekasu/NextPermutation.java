package com.vivekasu;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int larger = n-1;
        int curr = n-1;

        for(int i=n-1;i>=1;i--){

            if(nums[i]>nums[i-1]){
                curr = i-1;
                break;
            }

        }

        for(int i=n-1;i>=curr+1;i--){
            if(nums[i]>nums[curr]){
                larger = i;
                break;
            }
        }

        int tmp = nums[curr];
        nums[curr] = nums[larger];
        nums[larger] = tmp;
        int left = n-1;

        for(int i=curr+1;i<curr+((n-curr)/2+1);i++){
            int temp = nums[i];
            nums[i] = nums[left];
            nums[left] = temp;
            left--;
        }

        if(curr==n-1 && larger==n-1)
            Arrays.sort(nums);

    }
}
