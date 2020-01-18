package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, nums, 0, new ArrayList<>());

        return ans;

    }


    public void backtrack(List<List<Integer>> ans,int[] nums, int ind, List<Integer> temp ){

        if(temp.size()<=nums.length){
            ans.add(new ArrayList<>(temp));
            if(temp.size()==nums.length)
                return;
        }


        for(int i=ind;i<nums.length;i++){

            temp.add(nums[i]);
            backtrack(ans, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }

    }
}
