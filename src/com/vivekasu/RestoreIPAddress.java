package com.vivekasu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {

    int n;
    String s;
    private LinkedList<String> segments;
    private List<String> ans;

    public List<String> restoreIpAddresses(String s) {

        segments = new LinkedList<String>();
        ans = new ArrayList<String>();
        this.s = s;
        n = s.length();
        if(n>0)
            backtrack(-1,3);

        return ans;
    }


    public boolean isValid(String segment){

        int l = segment.length();

        if(l>3)
            return false;

        return segment.charAt(0)!='0'?(Integer.valueOf(segment)<=255):(l==1);
    }

    public void updateAns(int cur){

        String segment = s.substring(cur+1, n);
        if(isValid(segment)){
            segments.add(segment);
            ans.add(String.join(".",segments));
            segments.removeLast();
        }

    }

    public void backtrack(int prev, int dots){

        int maxpos = Math.min(n-1, prev + 4);

        for(int i=prev+1; i<maxpos; i++){

            String segment = s.substring(prev+1, i+1);
            if(isValid(segment)){
                segments.add(segment);

                if(dots-1==0)
                    updateAns(i);
                else
                    backtrack(i, dots - 1);

                segments.removeLast();
            }

        }

    }
}
