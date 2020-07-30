package com.vivekasu;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {

        if(s.length()<1)
            return 0;
        Stack<Integer> num = new Stack<>();
        int n = 0;
        char sign = '+';
        int val = 0;
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                n = 10*n + (int)(ch-'0');
            }
            if(i==s.length()-1 || (!Character.isDigit(ch) && ch!=' ' )){

                if(sign=='+'){
                    num.push(n);
                }
                else if(sign=='-'){
                    num.push(-n);
                }
                else if(sign=='/'){
                    num.push(num.pop()/n);
                }
                else if(sign=='*'){
                    num.push(num.pop()*n);
                }

                sign = ch;
                n = 0;

            }

        }

        for(int i: num)
            val+=i;

        return val;

    }
}
