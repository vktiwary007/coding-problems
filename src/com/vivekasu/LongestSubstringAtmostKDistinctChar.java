package com.vivekasu;

public class LongestSubstringAtmostKDistinctChar {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int max = 0;
        int n = s.length();

        char[] arr = s.toCharArray();
        int[] map = new int[128];
        int start = 0, end = 0;
        int count = 0;

        while(end<n){

            char ch = arr[end];
            if(map[ch]<0) map[ch] = 0;
            if(map[ch]==0) count++;
            map[ch]++;
            if(count<=k){
                end++;
                while(end<n && count<=k){

                    if(map[arr[end]]==0){
                        count++;
                    }

                    map[arr[end++]]++;

                }

                if(count>k)
                    end--;
                max = Math.max(max, end - start);
            }

            while(start<n && count>k){
                char cbegin = arr[start];
                map[cbegin]--;

                if(map[cbegin]==0) count--;
                start++;
            }

            end++;
        }


        return max;

    }
}
