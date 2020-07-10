package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {

        List<String> prev = new ArrayList<>();
        List<String> curr = ((n&1)==0)?Arrays.asList(""): Arrays.asList("0","1","8");

        if(n<2)
            return curr;

        for(;n>1;n-=2){
            prev = curr;
            curr = new ArrayList<>();
            for(String k: prev){
                if(n>3) curr.add('0'+k+'0');
                curr.add('1'+k+'1');
                curr.add('6'+k+'9');
                curr.add('8'+k+'8');
                curr.add('9'+k+'6');
            }

        }

        return curr;

    }
}
