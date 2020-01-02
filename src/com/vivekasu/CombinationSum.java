package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        combineSum(ans, new ArrayList<>(), target, candidates, 0);
        return ans;


    }


    public void combineSum(List<List<Integer>> ans, List<Integer> temp, int target, int[] candidates, int start){

        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(target<0)
            return;


        for(int i=start; i<candidates.length; i++){
            if(candidates[i]>target)
                continue;

            temp.add(candidates[i]);
            combineSum(ans, temp, target-candidates[i], candidates, i);
            temp.remove(temp.size()-1);
        }

    }
}
