package com.vivekasu;

public class OneEdit {

    public boolean isOneEditDistance(String s, String t) {

        int l1 = s.length();
        int l2 = t.length();

        if(l2<l1)
            return isOneEditDistance(t, s);

        if(l2 - l1 > 1)
            return false;

        for(int i=0;i<l1;i++){
            if(s.charAt(i)!=t.charAt(i)){

                if(l1==l2)
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i).equals(t.substring(i+1));

            }
        }

        return l1+1==l2;

    }
}
