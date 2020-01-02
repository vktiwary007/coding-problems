package com.vivekasu;

public class TrapRainWater {

    public int trap(int[] height) {

        int len = height.length;
        if(len<1)
            return 0;
        int left = 0;
        int right = len -1;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        leftmax[0] = height[0];
        rightmax[len-1] = height[len-1];
        int trap = 0;
        int currht = 0;
        for(int i=1;i<height.length;i++){
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        }

        for(int i=len-2;i>=0;i--){
            rightmax[i] = Math.max(height[i],rightmax[i+1]);
        }

        for(int i=0;i<len;i++){

            currht = Math.min(leftmax[i],rightmax[i]) - height[i];
            if(currht>0)
                trap = trap + currht;
        }

        return trap;

    }
}
