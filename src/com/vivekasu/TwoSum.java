package com.vivekasu;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] ind = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
                hm.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int getInd = target-nums[i];
            if(hm.containsKey(getInd) && i!=hm.get(getInd)){
                ind[0] = hm.get(getInd);
                ind[1] = i;
                break;
            }

        }

        return ind;
    }


    public static void main(String[] args) {
        // write your code here
        TwoSum obj = new TwoSum();
        int[] arr = {3,2, 4};
        int[] ind = obj.twoSum(arr, 6);
        System.out.println(ind[0]);
        System.out.println(ind[1]);
    }
}
