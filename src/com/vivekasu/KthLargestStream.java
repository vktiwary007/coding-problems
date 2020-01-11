package com.vivekasu;

import java.util.PriorityQueue;

public class KthLargestStream {

    PriorityQueue<Integer> que;
    int qsize;
    public KthLargestStream(int k, int[] nums) {

        que = new PriorityQueue<>();
        qsize = k;

        for(int i=0;i<nums.length;i++){

            que.add(nums[i]);

        }


    }

    public int add(int val) {

        que.add(val);
        while(que.size()>qsize)
            que.poll();

        return que.peek();
    }
}
