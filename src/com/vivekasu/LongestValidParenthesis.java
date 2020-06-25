package com.vivekasu;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        int longest = 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){
                st.push(i);
            }

            if(s.charAt(i)==')'){

                st.pop();

                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    longest = Math.max(longest, i - st.peek());
                }

            }


        }


        return longest;

    }
}
