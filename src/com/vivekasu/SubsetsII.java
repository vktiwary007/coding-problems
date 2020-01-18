package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, nums, 0, new ArrayList<>(), new boolean[nums.length]);

        return ans;
    }


    public void backtrack(List<List<Integer>> ans, int[] nums, int index, List<Integer> temp, boolean[] used){

        if(temp.size()<=nums.length){
            ans.add(new ArrayList<>(temp));
            if(temp.size()==nums.length)
                return;
        }



        for(int i=index;i<nums.length;i++){

            temp.add(nums[i]);
            backtrack(ans, nums, i+1, temp, used);
            temp.remove(temp.size()-1);
            while(i<nums.length-1 && nums[i+1]==nums[i]) i++;
        }

    }
}
