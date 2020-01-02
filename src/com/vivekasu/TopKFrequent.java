package com.vivekasu;

import java.util.*;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {

        if(nums.length<1)
            return null;
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer> topK = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( (a, b) -> count.get(a)-count.get(b));

        for(int i=0;i<nums.length;i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        for(int i:count.keySet()){
            pq.add(i);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty()){
            topK.add(pq.poll());
        }

        Collections.reverse(topK);

        return topK;
    }
}
