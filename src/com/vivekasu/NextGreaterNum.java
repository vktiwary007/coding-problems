package com.vivekasu;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterNum {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> nextGreatNum = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] nextGreatArr = new int[nums1.length];
        if(nums2.length<1 && nums1.length<1)
            return nextGreatArr;
        if(nums2.length>0)
            stack.push(nums2[0]);

        for(int i=1;i<nums2.length;i++){

            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                nextGreatNum.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }


        for(int i=0;i<nums1.length;i++){

            nextGreatArr[i] = nextGreatNum.getOrDefault(nums1[i],-1);
        }


        return nextGreatArr;
    }
}
