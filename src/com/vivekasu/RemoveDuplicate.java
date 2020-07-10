package com.vivekasu;

public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n<1)
            return 0;

        int len = 0;
        nums[len++] = nums[0];
        for(int i=1; i<nums.length; i++){

            int prev = i;
            while(i<nums.length && nums[i]==nums[i-1]) i++;
            if(i<nums.length)
                nums[len++] = nums[i];

        }


        return len;

    }


}
