package com.vivekasu;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Validparenthesis {

    public static void main(String[] args){

        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack();
        Set<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else if(c==')' || c==']' || c=='}'){
                char ch = st.pop();
                if(ch!='(' || ch!='{' || ch!='[')
                    return false;
            }
        }


        return true;
    }
}
