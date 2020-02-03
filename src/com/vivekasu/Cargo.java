package com.vivekasu;

import java.util.HashSet;
import java.util.Set;

public class Cargo {

    public static void main(String[] args){
        Cargo obj = new Cargo();
        int[] A = {70, 60, 30};
        int[] B = {4,2,1};
        System.out.println(obj.getCount(A,B,5,2,200));
    }

    public int getCount(int[] A, int[] B, int M, int X, int Y){

        Set<Integer> stops = new HashSet<>();
        int total = 0;

        for(int i=0;i<A.length;i++){
            int wt = 0;
            int n= 0;
            total++;

            while(i<A.length && n<X && wt + A[i] <=Y){
                    wt+=A[i];
                    n++;
                    stops.add(B[i]);
                    i++;
            }

            total+=stops.size();
            stops.clear();
        }


        return total;
    }
}
