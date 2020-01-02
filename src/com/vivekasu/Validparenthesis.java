package com.vivekasu;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Validparenthesis {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else if(c==')' || c==']' || c=='}'){
                if(st.isEmpty())
                    return false;
                char ch = st.pop();

                if(ch!='{' && c=='}')
                    return false;
                else if(ch!='(' && c==')')
                    return false;
                else if(ch!='[' && c==']')
                    return false;
            }
        }

        if(st.size()>0)
            return false;

        return true;
    }
}
