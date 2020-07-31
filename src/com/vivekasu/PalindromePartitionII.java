package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitionII {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        if(s.length()<1){
            ans.add(new ArrayList<>());
            return ans;
        }

        backtrack(ans, new ArrayList<>(), s, 0);

        return ans;

    }

    private void backtrack(List<List<String>> ans, List<String> temp, String s, int start){


        if(temp.size()>0 && start>=s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i=start;i<s.length();i++){

            if(checkPalindrome(s.substring(start, i+1))){
                if(i==start)
                    temp.add(String.valueOf(s.charAt(i)));
                else
                    temp.add(s.substring(start, i+1));
                backtrack(ans, temp, s, i+1);
                temp.remove(temp.size()-1);
            }

        }

    }

    private boolean checkPalindrome(String s){

        for(int i=0;i<s.length()/2 ;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }

        return true;
    }
}
