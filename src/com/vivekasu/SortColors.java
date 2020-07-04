package com.vivekasu;

public class SortColors {

    public void sortColors(int[] nums) {

        int i = 0, left = 0, right = nums.length - 1;

        while(i<=right){

            if(nums[i]==0)
                swap(nums, i++, left++);
            else if(nums[i]==2)
                swap(nums, i, right--);
            else
                i++;

        }

    }

    private void swap(int[] nums, int i, int j){

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}
