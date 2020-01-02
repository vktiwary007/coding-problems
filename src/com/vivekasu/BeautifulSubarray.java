package com.vivekasu;

public class BeautifulSubarray {

    public static void main(String[] args){

        BeautifulSubarray obj = new BeautifulSubarray();
        int[] a = {2,5,6,9};
        System.out.println(obj.getOddCount(a, 2));
    }

    public int getOddCount(int[] arr, int n){

        int[] count = new int[arr.length];
        if(arr[0]%2==1)
            count[0] = 0;
        else
            count[0] = 1;

        int sum = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2==1)
                count[i] = count[i-1] + 1;
            else
                count[i] = count[i-1];

        }

        return count[arr.length-1];
    }
}
