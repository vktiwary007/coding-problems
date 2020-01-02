package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<Integer>(), nums);

        return ans;
    }


    public void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums){

        if(tempList.size()==nums.length){
            List<Integer> temp = new ArrayList<>(tempList);
            ans.add(temp);
            return;
        }

        for(int i=0;i<nums.length;i++){

            if(tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums);
            tempList.remove(tempList.size()-1);
        }

    }
}
