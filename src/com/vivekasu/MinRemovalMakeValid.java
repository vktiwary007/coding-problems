package com.vivekasu;

public class MinRemovalMakeValid {

    public String minRemoveToMakeValid(String s) {

        if(s.isEmpty())
            return s;

        StringBuilder valid = getValid(s, new char[]{'(', ')'});
        valid = getValid(valid.reverse().toString(), new char[]{')', '('});

        return valid.reverse().toString();

    }

    public StringBuilder getValid(String s, char[] paren){

        StringBuilder valid = new StringBuilder();
        int count = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch==paren[0])
                count++;
            else if(ch==paren[1]){

                if(count==0)
                    continue;

                count--;
            }

            valid.append(ch);


        }

        return valid;
    }

}
