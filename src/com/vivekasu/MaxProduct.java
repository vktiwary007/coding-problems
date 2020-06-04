package com.vivekasu;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct obj = new MaxProduct();
        int[] nums = {3,4,5,2};
        int[] h = {3};
        int[] w = {3};
        //System.out.println(obj.maxProduct(nums));

        System.out.println(obj.maxArea(5,4,h,w));
    }

    public int maxProduct(int[] nums) {

        int max = Math.max(nums[0],nums[1]);
        int secondmax = Math.min(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){

            if(nums[i]>max){
                secondmax = max;
                max = nums[i];
            }
            else if(nums[i]<max && nums[i]>secondmax){
                secondmax = nums[i];
            }

        }


        return (max-1)*(secondmax-1);

    }


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] r = new int[horizontalCuts.length + 1];
        int[] c = new int[verticalCuts.length + 1];
        r[0] = horizontalCuts[0];
        c[0] = verticalCuts[0];
        int k = 1;
        int r_max = Integer.MIN_VALUE;
        for(int i=1;i<horizontalCuts.length;i++){
            r[k] = horizontalCuts[i]-horizontalCuts[i-1];
            r_max = Math.max(r[k],r_max);
            k++;
        }
        r[k] = h - horizontalCuts[horizontalCuts.length-1];
        r_max = Math.max(r[k],r_max);
        k=1;
        int c_max = Integer.MIN_VALUE;
        for(int i=1;i<verticalCuts.length;i++){
            c[k] = verticalCuts[i]-verticalCuts[i-1];
            if(c[k]>c_max)
                c_max = c[k];
            k++;
        }
        c[k] = w - verticalCuts[verticalCuts.length-1];
        c_max = Math.max(c_max, c[k]);

        return (c_max*r_max)%mod;

    }
}
