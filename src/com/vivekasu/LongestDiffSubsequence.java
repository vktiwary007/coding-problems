package com.vivekasu;

import java.util.HashMap;

public class LongestDiffSubsequence {

    public static void main(String[] args){

        int[] arr = {1,5,7,8,5,3,4,2,1};
        LongestDiffSubsequence obj = new LongestDiffSubsequence();
        System.out.println(obj.longestSubsequence(arr, -2));
    }


    public int longestSubsequence(int[] arr, int difference){
        int maxlen = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();


        for(int i=0;i<arr.length;i++){
           hm.put(arr[i], hm.getOrDefault(arr[i]-difference, 0)+1);
            maxlen = Math.max(hm.get(arr[i]), maxlen);
        }


        return maxlen;

    }
}
