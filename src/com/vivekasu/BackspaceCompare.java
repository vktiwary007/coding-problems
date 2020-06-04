package com.vivekasu;

public class BackspaceCompare {

    public static void main(String[] args){

        BackspaceCompare obj = new BackspaceCompare();
        String s1 = "isfcow#";
        String s2 = "isfco#w#";

        System.out.println(obj.backspaceCompare("isfcow#","isfco#w#"));
    }

    public boolean backspaceCompare(String S, String T) {

        for(int i=0;i<S.length();i++){

            if(S.charAt(i)=='#'){
                if(i==S.length()-1){
                    S = S.substring(0, Math.max(i-1,0));
                }
                else {
                    S = S.substring(0, Math.max(i - 1, 0)) + S.substring(Math.min(i + 1, S.length() - 1));
                }
                if(S.equalsIgnoreCase("#")){
                    S = "";
                    break;
                }

                i=Math.max(0, i-2) - 1;
            }

        }

        for(int i=0;i<T.length();i++){

            if(T.charAt(i)=='#'){
                if(i==T.length()-1){
                    T = T.substring(0, Math.max(i-1,0));
                }
                else {
                    T = T.substring(0, Math.max(i - 1, 0)) + T.substring(Math.min(i + 1, T.length() - 1));
                }
                if(T.equalsIgnoreCase("#")){
                    T = "";
                    break;
                }
                i=Math.max(0, i-2) - 1;
            }

        }

        return T.equalsIgnoreCase(S);

    }
}
