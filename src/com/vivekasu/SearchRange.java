package com.vivekasu;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        int l = 0, r = nums.length - 1;
        if(r<0)
            return pos;
        while(l<r){
            int mid = l + (r - l)/2;
            if(nums[mid]<target){
                l = mid + 1;
            }
            else{
                r = mid;
            }

        }

        if(nums[l]==target){
            pos[0] = l;
        }
        else
            return pos;

        r = nums.length - 1;
        while(l<r){
            int mid = (l + (r - l)/2)+1;
            if(nums[mid]>target){
                r = mid - 1;
            }
            else{
                l = mid;
            }
        }

        if(nums[r]==target)
            pos[1] = r;

        return pos;
    }
}
