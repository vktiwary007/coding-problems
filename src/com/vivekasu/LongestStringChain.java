package com.vivekasu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {

        if(words.length<1)
            return 0;

        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b)->(a.length()-b.length()));
        int max = 1;

        for(int i=0;i<words.length;i++){

            String word = words[i];
            int currLong = 1;
            for(int j=0;j<word.length();++j){
                String prevWord = new StringBuilder(word).deleteCharAt(j).toString();
                currLong = Math.max(currLong, map.getOrDefault(prevWord, 0)+1);
            }
            map.put(word, currLong);
            max = Math.max(max, currLong);
        }

        return max;
    }
}
