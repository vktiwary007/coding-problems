package com.vivekasu;

import java.util.*;

public class Distinctkchar {

    public static void main(String[] args){
        String s = "abcabc";

        List<String> op = getUniqueSubstrings(s,3);
        for(String st: op)
            System.out.println(st);
    }

    public static int getSubstringsCount( String str, int k){
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int prefix = 0;
        int distinct = 0;
        while(right<str.length()){
            char ch = str.charAt(right);

            if(!hm.containsKey(ch)){
                hm.put(ch, 1);
            }
            else{
                int c = hm.get(ch)+1;
                hm.put(ch, c);
            }
            if(hm.get(ch)==1){
                distinct++;
            }
            else{
                prefix = hm.get(ch) - 1;
            }
            if(distinct>k){
                hm.put(str.charAt(left),hm.get(str.charAt(left))-1);
                distinct--;
                left++;
                prefix = 0;
            }

            if(distinct==k)
                count = count + 1 + prefix;
            right++;
        }
        return  count;
    }


    public static List<String> getUniqueSubstrings(String str, int k){
        List<String> arr = new ArrayList<>();
        Set<String> arrset = new HashSet<>();
        int len = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int prefix = 0;
        int distinct = 0;
        while(right<str.length()){
            char ch = str.charAt(right);

            if(!hm.containsKey(ch)){
                hm.put(ch, 1);
            }
            else{
                int c = hm.get(ch)+1;
                hm.put(ch, c);
            }
            if(hm.get(ch)==1){
                distinct++;
            }
            else{
                prefix = hm.get(ch) - 1;
                distinct--;
            }
            len++;

            if(hm.size()==k && len==k){
                arrset.add(str.substring(left, right+1));
                hm.put(str.charAt(left),hm.get(str.charAt(left))-1);
                if(hm.get(str.charAt(left))==0)
                    hm.remove(str.charAt(left));
                distinct--;
                left++;
                len--;
                prefix = 0;
            }
            else if(len==k && hm.size()<k){
                hm.put(str.charAt(left),hm.get(str.charAt(left))-1);
                if(hm.get(str.charAt(left))==0)
                    hm.remove(str.charAt(left));
                left++;
                len--;
            }

            right++;
        }
        arr.addAll(arrset);
        return  arr;
    }
}
