package com.vivekasu;

import java.math.BigInteger;
import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();
        int n = num.length();
        char[] arr = num.toCharArray();
        int m = 0;
        String newnum = "";
        st.push(arr[0]);
        for(int i=1;i<n;i++){

            if(arr[i]<st.peek()){

                while(!st.isEmpty() && m<k && st.peek()>arr[i]){
                    st.pop();
                    m++;
                }

                st.push(arr[i]);

            }
            else{
                st.push(arr[i]);
            }
        }

        while(m<k && !st.isEmpty()){
            st.pop();
            m++;
        }

        while(!st.isEmpty()){
            newnum = newnum + st.pop();
        }

        StringBuilder sb=new StringBuilder(newnum);
        sb.reverse();
        if(sb.toString().isEmpty())
            sb = new StringBuilder("0");

        BigInteger big = new BigInteger(sb.toString());
        newnum = String.valueOf(big);

        return newnum;
    }
}
