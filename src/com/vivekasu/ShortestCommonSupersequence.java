package com.vivekasu;

public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        if(n1==0)
            return str2;
        if(n2==0)
            return str1;

        int[][] dp = new int[n1+1][n2+1];
        for(int i=1; i<=n1;i++){
            dp[i][0] = i;
        }

        for(int i=0;i<=n2;i++){
            dp[0][i] = i;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        int l = dp[n1][n2];

        int i = n1, j = n2;
        char[] arr = new char[l];
        while(i>0 && j>0){

            if(str1.charAt(i-1)==str2.charAt(j-1)){
                arr[--l] = str1.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]<dp[i][j-1]){
                    arr[--l] = str1.charAt(i-1);
                    i--;
                }
                else{
                    arr[--l] = str2.charAt(j-1);
                    j--;
                }
            }

        }

        while(i>0){
            arr[--l] = str1.charAt(i-1);
            i--;
        }

        while(j>0){
            arr[--l] = str2.charAt(j-1);
            j--;
        }

        return new String(arr);

    }
}
