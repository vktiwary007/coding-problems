package com.vivekasu;

public class LongestSubstringAtleastKRepeat {

    public int longestSubstring(String s, int k) {

        int d = Integer.MIN_VALUE;
        for(int i=1;i<=26;i++){
            int unique = 0;
            int begin = 0, end = 0, counter = 0;
            int[] map = new int[128];
            while(end<s.length()){
                char ch = s.charAt(end);
                if(map[ch]++==0)
                    unique++;
                //map[ch]++;
                if(map[ch]==k)
                    counter++;

                while(unique>i){
                    char c = s.charAt(begin);
                    if(map[c]--==k)
                        counter--;
                    if(map[c]==0){
                        unique--;
                        map[c] = 0;
                    }

                    begin++;
                }

                if(unique==i && unique==counter)
                    d = Math.max(d, end - begin + 1);

                end++;
            }

        }

        return d==Integer.MIN_VALUE?0:d;

    }
}
