package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> parenthesis = new ArrayList<>();
        backtrack(parenthesis, "", 0, 0, n);
        return parenthesis;

    }

    public void backtrack(List<String> output, String temp, int open, int close, int n){

        if(temp.length()==n*2){
            output.add(temp);
            return;
        }

        if(open<n){
            backtrack(output, temp+"(", open+1,close,n);
        }
        if(close<open){
            backtrack(output, temp+")", open,close+1,n);
        }

    }
}
