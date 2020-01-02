package com.vivekasu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoviesOnFlight {

    public static void main(String[] args){
        List<Integer> movie = new ArrayList<>();
        movie.add(90);
        movie.add(85);
        movie.add(75);
        movie.add(60);
        movie.add(120);
        movie.add(150);
        movie.add(125);
        List<Integer> pair = moviePairs(movie,250);
        for(int i:pair)
            System.out.println(i);
    }

    public static List<Integer> moviePairs(List<Integer> movieDurations, int d){
        List<Integer> pairs = new ArrayList<>();
        List<List<Integer>> indexDurationPair = new ArrayList<>();
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        };
        int ind = 0;
        for( int dur:movieDurations){
            List<Integer> pair = new ArrayList<>();
            pair.add(ind);
            pair.add(dur);
            indexDurationPair.add(pair);
            ind++;
        }

        Collections.sort(indexDurationPair, comparator);

       int start = 0;
       int right = indexDurationPair.size()-1;
       int currdiff = Integer.MAX_VALUE;
       int i = 0;
       int j = 0;
       d = d-30;
       while(start<right){
           int sum = indexDurationPair.get(start).get(1)+ indexDurationPair.get(right).get(1);
           if(sum>d)
               right--;
           else{

               int diff = d - sum;
               if(diff>=0 && diff<currdiff){
                   currdiff = diff;
                   i = indexDurationPair.get(start).get(0);
                   j = indexDurationPair.get(right).get(0);
               }
               else if(diff==currdiff){
                   int currmax = indexDurationPair.get(j).get(1);
                   if(currmax!=Math.max(indexDurationPair.get(right).get(1),currmax)){
                       i = indexDurationPair.get(start).get(0);
                       j = indexDurationPair.get(right).get(0);
                   }
               }
               start++;
           }

       }

       pairs.add(i);
       pairs.add(j);
       return pairs;
    }
}
