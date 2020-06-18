package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {

    List<String> ans;
    public List<String> removeInvalidParentheses(String s) {

        ans = new ArrayList<>();

        dfs(s, 0, 0, new char[]{'(',')'});

        return ans;

    }

    public void dfs(String s, int iStart, int jStart, char[] par){

        int count = 0;
        for(int i=iStart;i<s.length();i++){

            if(s.charAt(i)==par[0])
                count++;
            else if(s.charAt(i)==par[1])
                count--;

            if(count<0){

                for(int j=jStart;j<=i;j++){

                    if(s.charAt(j)==par[1] && (j==jStart || s.charAt(j-1)!=par[1])){

                        String st = s.substring(0, j) + s.substring(j+1, s.length());
                        dfs(st, i, j, par);

                    }

                }

                return;
            }

        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            dfs(reverse,0,0,new char[]{')','('});
        else
            ans.add(reverse);

    }
}
