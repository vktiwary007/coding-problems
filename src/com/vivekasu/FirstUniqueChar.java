package com.vivekasu;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {

        int[] count = new int[27];
        int opindex = -1;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a'] = count[s.charAt(i)-'a'] + 1;
        }

        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1){
                opindex = i;
                break;
            }

        }

        return opindex;

    }
}
