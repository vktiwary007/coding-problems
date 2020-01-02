package com.vivekasu;

import java.util.HashSet;
import java.util.Set;

public class CountDiffWords {

    public static void main(String[] args){
        CountDiffWords obj = new CountDiffWords();
        System.out.println(obj.getCount("ab12c","ab24z"));
    }

    public int getCount(String s, String t){

        int count = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                String st = s.substring(0,i)+s.substring(i+1);
               if(st.compareTo(t)<0){
                   count++;
               }
            }
        }

        for(int i=0;i<t.length();i++){
            if(t.charAt(i)>='0' && t.charAt(i)<='9'){
                String st = t.substring(0,i)+t.substring(i+1);
                if(st.compareTo(s)>0){
                    count++;
                }
            }
        }


        return count;

    }
}
