package com.vivekasu;

public class NumKDigits {

    private static int K_val;
    private static int digit = 0;
    private static int mod = 1000000007;
    private static String N;
    private static long[][][] dp;

    public static void main(String[] args) {
        String L = "1";
        String R = "100";

        System.out.println(getNumberOfIntegers(L,R,1));
    }

    public static int getNumberOfIntegers(String L, String R, int K) {
        // Write your code here

        K_val = K;
        long L_count = solve(L);
        long R_count = solve(R);


        return (int)((R_count - L_count)%mod) ;

    }

    public static long solve(String A){
        N = A;
        dp = new long[A.length()+1][K_val+1][2];

        for(int i=0;i<A.length()+1;i++){
            for(int j=0;j<K_val+1;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1l;
                }
            }
        }

        return getCountIntegers(0, 0, 0)%mod;

    }

    public static long getCountIntegers(int f, int pos, int k){

        if(k>K_val){
            return 0l;
        }

        if(pos==N.length()){
            if(k==K_val)
                return 1l;
            return 0l;
        }

        if(dp[pos][k][f]!=-1)
            return dp[pos][k][f];

        int largest = 0;

        if(f==0){
            largest = Integer.valueOf(N.charAt(pos)+"");
        }
        else{
            largest = 9;
        }

        long result = 0l;


        for(int i=0;i<=largest;i++){
            int nf = f;
            int currK = k;

            if(f==0 && i<largest)
                nf = 1;

            if(i!=digit)
                currK++;

            if(currK<=K_val)
                result+=getCountIntegers(nf, pos+1, currK);

        }

        dp[pos][k][f] = result;

        return result;

    }
}
