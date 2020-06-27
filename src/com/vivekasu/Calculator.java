package com.vivekasu;

import java.util.Stack;

public class Calculator {

    public int calculate(String s) {

        int cal = 0;
        Stack<Object> op = new Stack<>();
        int n = 0;
        int val = 0;
        for(int i=s.length()-1;i>=0;i--){

            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                val+= Math.pow(10,n)*Character.getNumericValue(ch);
                n++;
            }
            else if(ch!=' '){
                if(n!=0){
                    op.push(val);
                    val = 0;
                    n = 0;
                }
                if(ch=='('){
                    int res = evaluateExpr(op);
                    op.pop();
                    op.push(res);
                }
                else{
                    op.push(ch);
                }

            }


        }

        if(n!=0)
            op.push(val);

        cal = evaluateExpr(op);

        return cal;

    }

    public int evaluateExpr(Stack<Object> st){

        int res = 0;

        if(!st.isEmpty()){
            res = (int)st.pop();
        }

        while(!st.isEmpty() && (char)st.peek()!=')'){

            char sign = (char)st.pop();
            if(sign =='+')
                res+=(int)st.pop();
            else if(sign =='-')
                res-=(int)st.pop();

        }

        return res;
    }
}
