package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if(k<1 || n<1)
            return ans;

        backtrack(ans, n, new ArrayList<>(), 1, k);

        return ans;

    }

    public void backtrack(List<List<Integer>> ans, int n, List<Integer> temp, int index, int k ){

        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<=n;i++){

            temp.add(i);
            backtrack(ans, n, temp, i+1, k);
            temp.remove(temp.size()-1);
        }

    }
}
