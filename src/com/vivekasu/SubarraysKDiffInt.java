package com.vivekasu;

import java.util.HashMap;

public class SubarraysKDiffInt {

    public int subarraysWithKDistinct(int[] A, int K) {

        if(K<1 || A.length<1 || (K>A.length))
            return 0;

        HashMap<Integer, Integer> distinct = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        int n = A.length;

        while(right<n){

            int num = A[right];
            distinct.put(num, distinct.getOrDefault(num, 0)+1);

            while(distinct.size()==K){

                int dup = right;

                while(dup+1<n && distinct.containsKey(A[dup+1])){
                    dup++;
                }
                count = count + (dup - right) + 1;
                int rem = A[left];
                distinct.put(rem, distinct.getOrDefault(rem, 0)-1);
                if(distinct.get(rem)<1){
                    distinct.remove(rem);
                }

                left++;
            }

            right++;
        }


        return count;

    }
}
