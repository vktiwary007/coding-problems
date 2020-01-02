package com.vivekasu;

public class MostWaterContainer {

    public int maxArea(int[] height) {

        int maxVol = 0;
        int start = 0;
        int end = height.length-1;
        int lheight = height[start];
        int rheight = height[end];
        int vol = Math.min(lheight,rheight)*(end-start);

        maxVol = vol;
        while(start<end){

            if(lheight<rheight){
                start++;
                lheight = height[start];
            }
            else{
                end--;
                rheight = height[end];
            }

            vol = Math.min(lheight,rheight)*(end-start);
            if(vol>maxVol)
                maxVol = vol;
        }

        return maxVol;

    }
}
