package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class Minways {

    public static int minWays(int n, int[] arr) {
        List<Integer> inBetweenZeros = new ArrayList<Integer>();
        int currentZeros = 1;
        boolean isFirst = false;
        for (int i = 0; i < arr.length; i++) {
            if (!isFirst && arr[i] == 1) {
                isFirst = true;
            } else if (arr[i] == 1) {
                inBetweenZeros.add(currentZeros);
                currentZeros = 1;
            } else if (arr[i] == 0) {
                currentZeros++;
            }
        }
        int res = isFirst ? 1 : 0;
        for(int zeros : inBetweenZeros){
            res *= zeros;
        }
        return res;
    }

    public static void main(String [] args){
        //System.out.println(minWays(5, new int[] {1,0,1,1,1,1,1,1}));

        int[] a = {70, 60, 30};
        int[] b = {2, 4, 1};
        System.out.println(getSolution(a,b,2,150));
    }

    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y < X) {
            ans++;
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
        }
        return ans + X - Y;
    }

    public static int getSolution(int[] A, int[] B, int X, int Y){
        int n = A.length;
        int trips = 0;
        int i = 0;
        while(i<n){
            trips++;
            int containers = 0;
            int weight = 0;
            for(int j=i; j<n; j++){
                weight = weight +A[j];
                containers++;
                if(weight>Y || containers>X){
                    i = j;
                    break;
                }
                if(j>0 && B[j-1]==B[j] && containers>1){
                    continue;
                }
                else {
                    trips++;
                }

                i++;
            }
        }

        return trips;
    }
}
