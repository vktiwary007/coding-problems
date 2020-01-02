package com.vivekasu;

public class Maxwatercontainer {
    public static void main(String[] args){

    }

    public static int maxArea(int[] height) {

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


    public int maxAreaWrong(int[] height) {



        int maxarea = 0;
        int minlen = 0;
        int x1 =0;
        int maxlen = 0;
        int x2 = 0;

        if(height[0]>height[1]){
            maxlen = height[0];
            minlen = height[1];
            x2 = 0;
            x1 = 1;
        }
        else{
            maxlen = height[1];
            minlen = height[0];
            x2 = 1;
            x1 = 0;
        }
        if(height.length==2)
            return Math.abs(minlen*(x2-x1));

        for(int i=2; i<height.length;i++){

            if(Math.abs(height[i]*(i-x2))>Math.abs(minlen*(i-x1))){
                minlen = height[i];
                x1 = i;
            }
            else if(Math.abs(height[i]*(i-x1))>Math.abs(maxlen*(i-x2))){
                maxlen = height[i];
                x2 = i;
            }
            else{
                if(x2>x1)
                    x2=i;
                else
                    x1=i;

            }

        }
        maxarea = Math.abs(minlen*(x2-x1));
        return maxarea;

    }
}
