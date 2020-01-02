package com.vivekasu;

public class MissingElementSortedArr {

    public int missingElement(int[] nums, int k) {

        int n = nums.length;
        if(k>getMissingDiff(nums, n-1)){
            return nums[n-1] + k - (getMissingDiff(nums, n-1));
        }

        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left<right){
            mid = left + (right-left)/2;

            if(k>getMissingDiff(nums, mid)){
                left = mid+1;
            }
            else {
                right = mid;
            }

        }

        return nums[left-1] + k - (getMissingDiff(nums, left-1));
    }

    public int getMissingDiff(int[] nums, int index){

        return nums[index] - nums[0] - index;
    }
}
