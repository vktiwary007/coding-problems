package com.vivekasu;

import java.math.BigInteger;
import java.util.*;

public class StrangeSorting {

    public static void main(String[] args){

        List<Integer> mapping = new ArrayList<>();
        mapping.add(0);
        mapping.add(1);
        mapping.add(2);
        mapping.add(3);
        mapping.add(4);
        mapping.add(5);
        mapping.add(6);
        mapping.add(7);
        mapping.add(8);
        mapping.add(9);
        List<String> nums = new ArrayList<>();
        nums.add("180");
        nums.add("84");
        nums.add("99");
        nums.add("003");
        nums.add("53");
        nums.add("28");
        nums.add("60");
        nums.add("070");
        nums.add("1");
        List<String> op = strangeSort(mapping, nums);
        for(String i:op){
            System.out.println(i);
        }

    }

    public static List<String> strangeSort(List<Integer> mapping, List<String> nums){
        List<String> op = new ArrayList<String>();
        List<List<String>> mappedNum = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0;i<mapping.size();i++){
            hm.put(mapping.get(i)+"",i);
        }
        for(String i: nums){
            String newNum = "";

            for(char ch : i.toCharArray()){
                newNum = newNum+ hm.get(ch+"");
            }
            List<String> num = new ArrayList<>();
            num.add(i);
            num.add(newNum);
            mappedNum.add(num);
        }



        Collections.sort(mappedNum, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                BigInteger b1 = new BigInteger(o1.get(1));
                BigInteger b2 = new BigInteger(o2.get(1));
                return b1.compareTo(b2);
            }
        });

        for(int i=0;i<mappedNum.size();i++){
            op.add(mappedNum.get(i).get(0).toString());
        }

        return op;
    }
}
