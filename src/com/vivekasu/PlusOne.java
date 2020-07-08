package com.vivekasu;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int sum = 0;
        int carry = 0;
        int len = digits.length;
        int[] num = new int[len+1];
        for(int i=len-1;i>=0;i--){
            if(i==len-1)
                sum = digits[i] + 1;
            else
                sum = digits[i] + carry;
            carry = sum/10;
            num[i+1] = sum%10;
        }

        if(carry>0){
            num[0] = carry;
            return num;
        }

        return Arrays.copyOfRange(num, 1, len+1);

    }
}
