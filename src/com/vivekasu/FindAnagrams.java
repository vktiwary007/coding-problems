package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        int[] arr = new int[26];
        int[] cnt = new int[26];
        List<Integer> ans = new ArrayList<>();

        if(p.length()>s.length())
            return ans;

        for(int i=0;i<p.length();i++){
            cnt[p.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            arr[ch-'a']++;

            if(i>=p.length()){
                arr[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(arr, cnt))
                ans.add(i - p.length() + 1);

        }

        return ans;

    }
}
