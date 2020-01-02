package com.vivekasu;

import java.util.PriorityQueue;

public class KthLargest {

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
