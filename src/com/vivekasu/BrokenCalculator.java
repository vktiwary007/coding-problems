package com.vivekasu;

public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {

        int oper = 0;

        while(Y>X){
            oper++;
            if(Y%2==1)
                Y+=1;
            else
                Y/=2;
        }

        return oper + X - Y;

    }
}
