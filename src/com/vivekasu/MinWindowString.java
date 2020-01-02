package com.vivekasu;

import java.util.HashMap;

public class MinWindowString {


    public static void main(String[] args){

        String a = "aaaaaaaaaaaabbbbbcdd";
        String b = "abcdd";

        System.out.println(minWindow(a,b));
    }

    public static String minWindow(String s, String t) {

        if(t.length()>s.length()){
            return "";
        }

        String minWindow = "";
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hmCount = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
            //hmCount.put(t.charAt(i),hmCount.getOrDefault(t.charAt(i),0)+1);
        }

        int right = 0;
        int left = 0;
        int count = 0;
        boolean rightUpdate = true;
        while(left<=right && right<s.length()){

            char ch = s.charAt(right);
            if(hm.containsKey(ch) && rightUpdate){

                hmCount.put(ch,hmCount.getOrDefault(ch, 0)+1);
                if(hmCount.get(ch)==hm.get(ch))
                    count++;
            }
            if(count==hm.size()){

                if(right-left<minLen){
                    minWindow = s.substring(left, right+1);
                    minLen = right-left;
                }

                if(hm.containsKey(s.charAt(left))){
                    hmCount.put(s.charAt(left), hmCount.get(s.charAt(left))-1);
                    if(hmCount.get(s.charAt(left))<hm.get(s.charAt(left)))
                        count--;
                }

                left++;
                rightUpdate = false;
            }
            else{
                rightUpdate = true;
                right++;
            }


        }

        return minWindow;

    }

}
