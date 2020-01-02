package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> op = new ArrayList();
        HashMap<String, Integer> hm = new HashMap();
        int ind = 0;
        for(String str : strs){

            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);

            int currind = hm.getOrDefault(st,-1);
            if(currind==-1){
                List<String> arr = new ArrayList();
                arr.add(str);
                op.add(ind, arr);
                hm.put(st, ind);
                ind++;
            }
            else{
                op.get(hm.get(st)).add(str);
            }
        }

        return op;
    }
}
