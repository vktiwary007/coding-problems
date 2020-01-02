package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        combineSum(ans, new ArrayList<Integer>(), candidates, target, 0, used);

        return ans;

    }



    public void combineSum(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int index, boolean[] used){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i=index; i<candidates.length;i++){

            if(candidates[i]>target || used[i] || (i>0 && candidates[i]==candidates[i-1] && !used[i-1]))
                continue;

            used[i] = true;
            temp.add(candidates[i]);
            combineSum(ans, temp, candidates, target-candidates[i], i+1, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}
