package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumLetterCombinations {

    char[][] digitletters = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(ans,"", digits, digits.length());
        return ans;

    }

    public void backtrack(List<String> ans, String temp, String digits, int len){

        if(temp.length()==len){
            ans.add(temp);
            return;
        }
        char[] letters = digitletters[Integer.parseInt(digits.substring(0,1))-2];
        for(int i=0;i<letters.length;i++){

            temp = temp+letters[i];
            backtrack(ans, temp, digits.substring(1), len);
            temp = temp.substring(0,temp.length()-1);
        }

    }
}
