package com.vivekasu;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int count = 0;
        while(n>=5){

            count = count + n/5;
            n = n/5;

        }

        return count;
    }
}
