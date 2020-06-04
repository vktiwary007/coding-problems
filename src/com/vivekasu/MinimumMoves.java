package com.vivekasu;

public class MinimumMoves {

    public static int minimumMoves(String s, int d) {
        // Write your code here

        int moves = 0;
        int left = 0;
        int right = 0;
        boolean first1 = s.charAt(0)=='1';
        int i = 0;
        while(right<s.length()){

            if(s.charAt(right)=='1'){
                left = right;
            }
            else{
                if(right - left + 1 >= d){
                    if(!first1 && left==0 || right - left + 1 > d) {
                        moves++;
                        left = right;
                    }

                }
            }

            right++;

        }

        return moves;

    }
}
