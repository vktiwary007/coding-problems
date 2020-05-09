package com.vivekasu;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KthLargest {

    public static void main(String[] args){
        TreeMap map = new TreeMap();
        map.put("one","1st");
        map.put("second",new Integer(2));
        map.put("third","third");
        map.put("third","III");
        System.out.println(map.entrySet());
    }

    public int findKthLargest(int[] nums, int k) {

        if(k>nums.length)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (a, b)->a-b);

        for(int i=0;i<nums.length;i++){

            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }

        return pq.poll();

    }
}
