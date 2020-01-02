package com.vivekasu;

public class LongestPalindromeSubstring {

    public static void main(String[] args){
        System.out.println(getLongestPalindrome("cbbd"));
    }

    public static String getLongestPalindrome(String str){
        if(str.isEmpty())
            return str;
        char[] charr = str.toCharArray();
        int max = 0;
        StringBuilder palindrome = new StringBuilder();
        boolean[][] checkpalindrome = new boolean[charr.length][charr.length];
        int start = 0;
        int end = 0;
        for(int i=0;i<charr.length;i++){
            checkpalindrome[i][i] = true;
        }
        for(int i=0;i <charr.length-1; i++){
            if(charr[i]==charr[i+1]){
                checkpalindrome[i][i+1] = true;
                start = i;
                end = i+1;
                max = 2;
            }
        }

        for(int l=3; l<=charr.length;l++){
            for(int i=0; i<charr.length-l+1;i++){
                int j = i+l-1;
                if(checkpalindrome[i+1][j-1] && charr[i]==charr[j]){
                    checkpalindrome[i][j] = true;
                    if(l>max){
                        max = l;
                        start = i;
                        end = j;
                    }

                }
            }
        }

        palindrome.append(str.substring(start, end+1));

        return palindrome.toString();
    }
}
