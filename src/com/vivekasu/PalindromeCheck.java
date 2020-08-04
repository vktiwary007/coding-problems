package com.vivekasu;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        if(s.isEmpty())
            return true;
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();
        while(left<right){

            while(left<s.length() && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(right>=0 && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(left<right && s.charAt(left)!=s.charAt(right))
                return false;

            right--;
            left++;

        }

        return true;

    }
}
