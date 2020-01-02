package com.vivekasu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaxSubstring {


        public static void main(String[] args){

            MaxSubstring obj = new MaxSubstring();
            int[] counts = {3,3,3,3,3,1,3};
            obj.getGroups(counts);
        }


        public List<int[]> getGroups(int[] counts){

            Map<Integer, List<Integer> > hm = new LinkedHashMap<>();
            for(int i=0;i<counts.length;i++){
                if(!hm.containsKey(counts[i])){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    hm.put(counts[i],lst);
                }
                else{
                    hm.get(counts[i]).add(i);
                }
            }

            List<int[]> op = new ArrayList<>();
            for(int i: hm.keySet()){
                int p=0;
                int[] k = new int[i];
                for(int j : hm.get(i)){
                    if(p>=i) {
                        p = 0;
                        op.add(k);
                        k = new int[i];
                    }
                    k[p] = j;
                    p++;
                }
                op.add(k);
            }

            for(int [] a : op){
                for(int i : a){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return op;

        }


}
