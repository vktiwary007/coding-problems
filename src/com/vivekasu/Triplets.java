package com.vivekasu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Triplets {

    public static void main(String[] args){

        int[] nums = {-1,0,1,2,-1,-4};
        Triplets obj = new Triplets();
        System.out.println(obj.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){

            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                int sum = 0 - nums[i];
                if(count.containsKey(nums[j]-sum)){
                    int getCount = count.get(nums[j]-sum);
                    List<Integer> pair = new ArrayList<>();
                    if(nums[i]!=(nums[j]-sum) && getCount>=1){
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        pair.add(nums[j]-sum);
                        count.put(nums[j]-sum, getCount--);
                        triplets.add(pair);
                    }
                    else if(nums[i]==(nums[j]-sum) && getCount>1){
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        pair.add(nums[j]-sum);
                        count.put(nums[j]-sum, getCount--);
                        triplets.add(pair);
                    }
                }

            }
        }


        return triplets;

    }
}
