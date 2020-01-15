package com.vivekasu;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] longest = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    longest[i][j] = 1 + longest[i-1][j-1];
                }
                else{
                    longest[i][j] = Math.max(longest[i-1][j], longest[i][j-1]);
                }
            }
        }

        return longest[n][m];

    }
}
