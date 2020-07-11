package com.vivekasu;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(obj.topKFrequent(arr, 2));
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();

        List<String> ans = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b)->count.get(a).equals(count.get(b))?b.compareTo(a):(count.get(a)-count.get(b)));

        for(String word: words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for(String word: count.keySet()){
            pq.add(word);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty()){
            ans.add(0, pq.poll());
        }

        return ans;

    }
}
