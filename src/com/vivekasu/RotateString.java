package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class RotateString {

    public static void main(String[] args){

        RotateString obj = new RotateString();
        String str = "ephjos";
        List<Integer> amt = new ArrayList<>();
        amt.add(7);
        amt.add(4);
        List<Integer> direction = new ArrayList<>();
        direction.add(1);
        direction.add(0);
        System.out.println(obj.getRotatedString(str,amt,direction));

    }

    public String getRotatedString(String originalString, List<Integer> amount, List<Integer> directions){


        /*int[] str = new int[originalString.length()];
        for(int i=0;i<originalString.length();i++){

        }*/
        String outputString = "";
        String str = originalString;
        int amtleft = 0;
        int amtright = 0;
        for(int i=0;i<amount.size();i++){
            int amt = amount.get(i);
            int d = directions.get(i);
            if(d==0) {
                amtleft = amtleft + amt;
                amtleft = amtleft%originalString.length();

            }
            else{
                amtright = amtright + amt;
                amtright = amtright%originalString.length();

            }

            int diff = amtleft - amtright;
            if(diff>=0){
                outputString = leftRotate(str, Math.abs(diff)%originalString.length());
            }
            else{
                outputString = rightRotate(str, Math.abs(diff)%originalString.length());
            }
            str = outputString;

        }

        return outputString;

    }

    public String leftRotate(String str, int d){
        String ans = str.substring(d) + str.substring(0,d);
        return ans;
    }

    public String rightRotate(String str, int d){
        return leftRotate(str, str.length()-d);
    }
}
