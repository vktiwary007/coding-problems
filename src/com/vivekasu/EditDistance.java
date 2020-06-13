package com.vivekasu;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        if(n==0 || m==0)
            return Math.max(n, m);

        int[][] edit = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            edit[i][0] = i;

        for(int i=0;i<m+1;i++){
            edit[0][i] = i;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int left = edit[i-1][j] + 1;
                int down = edit[i][j-1] + 1;
                int left_down = edit[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    left_down+=1;
                }

                edit[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }


        return edit[n][m];

    }

}
