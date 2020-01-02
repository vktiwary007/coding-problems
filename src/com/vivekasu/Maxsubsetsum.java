package com.vivekasu;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Maxsubsetsum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, arr[0]);
        hm.put(1, arr[1]);
        int max = arr[0]>arr[1]?arr[0]:arr[1];
        for(int i=2;i < arr.length;i++){

            hm.put(i, Math.max(hm.getOrDefault(i-2,0)+arr[i],arr[i] ));
            if(hm.get(i)>max)
                max = hm.get(i);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {3,7,4,6,5};

        int res = maxSubsetSum(arr);

        System.out.println(res);

    }
}
