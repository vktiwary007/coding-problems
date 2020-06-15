package com.vivekasu;

public class RegExMatch {

    public boolean isMatch(String s, String p) {

        if(p.isEmpty())
            return s.isEmpty();

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=0;i<m;i++){
            if(p.charAt(i)=='*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(p.charAt(j)=='.' || p.charAt(j)==s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j)=='*'){
                    if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else{
                        dp[i+1][j+1] = dp[i][j+1] | dp[i+1][j-1] | dp[i+1][j];
                    }
                }

            }
        }


        return dp[n][m];

    }
}
