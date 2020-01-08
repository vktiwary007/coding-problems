package com.vivekasu;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int l = nums.length;
        if(l<1)
            return 0;

        int left = l-1;
        for(int i=0;i<left;i++){

            if(nums[i]==val){

                while(left>=0 && nums[left]==val)
                    left--;
                if(left<i){
                    left = i;
                }
                int tmp = nums[left];
                nums[i] = tmp;
                nums[left] = val;
                left--;
            }

        }

        return left>=0?(nums[left]!=val?left+1:left):0;

    }
}
