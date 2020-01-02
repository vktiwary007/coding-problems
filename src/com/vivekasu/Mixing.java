package com.vivekasu;

import java.util.*;

public class Mixing {

    public static void main(String[] args){

        System.out.println(mix("Are they here", "yes, they are here"));
    }

    public static class MixNode{

        private int count;
        private String value;

        public MixNode(int count, String value){

            this.count = count;
            this.value = value;

        }

    }

    public static class MixComparator implements Comparator<MixNode>{

        @Override
        public int compare(MixNode n1, MixNode n2){

            if(n1.count==n2.count)
                return n1.value.compareTo(n2.value);

            return n2.count - n1.count;
        }

    }

    public static String mix(String s1, String s2) {
        // your code

        int[] s1count = new int[26];
        int[] s2count = new int[26];
        HashMap<Integer, String> maxCount = new HashMap<>();

        PriorityQueue<MixNode> countQueue = new PriorityQueue<>(new MixComparator());

        setCharacterCount(s1, s1count);
        setCharacterCount(s2, s2count);

        for(int i=0;i<26;i++){
            if(s1count[i]>1 || s2count[i]>1){


                String currCh = String.valueOf((char)('a'+i));
                if(s1count[i]>s2count[i])
                    countQueue.add(new MixNode(s1count[i],"1:"+new String(new char[s1count[i]]).replace("\0", currCh)));
                else if(s1count[i]<s2count[i])
                    countQueue.add(new MixNode(s2count[i],"2:"+new String(new char[s2count[i]]).replace("\0", currCh)));
                else
                    countQueue.add(new MixNode(s1count[i],"=:"+new String(new char[s1count[i]]).replace("\0", currCh)));

            }
        }

        String sequence = "";
        while(!countQueue.isEmpty()){
            sequence = sequence + countQueue.poll().value;
            if(!countQueue.isEmpty())
                sequence = sequence + "/";
        }


        return sequence;

    }

    public static void setCharacterCount(String s, int[] count){

        for(int i=0;i<s.length();i++){

            char currCh = s.charAt(i);
            if(currCh-'a'>=0 && currCh-'a'<26)
                count[currCh-'a'] =  count[currCh-'a']+1;

        }
    }
}