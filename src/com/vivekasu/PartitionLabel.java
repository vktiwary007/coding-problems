package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

    public List<Integer> partitionLabels(String S) {

        int[] lastpos = new int[26];
        for(int i=0;i<S.length();i++){
            lastpos[S.charAt(i)-'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> oplen = new ArrayList<>();
        for(int i=0;i<S.length();i++){

            end = Math.max(end,lastpos[S.charAt(i)-'a']);
            if(i==end){
                oplen.add(end-start+1);
                start = i+1;
            }
        }

        return oplen;

    }
}
