package com.vivekasu;

import java.util.Random;

public class RandomPickWeight {

    int[] freq;
    public RandomPickWeight(int[] w) {

        freq = new int[w.length];
        freq[0] = w[0];

        for(int i=1;i<w.length;i++){
            freq[i] = freq[i-1] + w[i];
        }

    }

    public int pickIndex() {

        int n = freq.length;
        double ind = freq[n-1]*Math.random();
        int left = 0, right = n;

        while(left < right){
            int mid = left + (right - left)/2;
            if(freq[mid]==ind)
                return mid;
            else if(freq[mid]<ind)
                left = mid +1;
            else
                right = mid;
        }


        return left;

    }
}
