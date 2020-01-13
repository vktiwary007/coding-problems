package com.vivekasu;

public class Powxn {

    public double myPow(double x, int n) {

        long N = n;

        if(n<0){
            x = 1/x;
            N = -N;
        }

        return calpow(x, N);
    }

    public double calpow(double x, long n){

        if(n==0)
            return 1.0;

        double num = calpow(x, n/2);
        if(n%2==0){
            return num*num;
        }
        else{
            return num*num*x;
        }

    }
}
