package com.vivekasu;

public class UglyNum {

    public boolean isUgly(int num) {

        int[] arr = {2,3,5};
        int val = num;

        for(int d: arr){

            while(val>=d && val%d==0){

                val/=d;

            }

        }

        return val==1;

    }
}
