package com.vivekasu;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;
        int[] ind = new int[2];
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                ind[0] = start+1;
                ind[1] = end+1;
                break;
            }
            else if(numbers[start]+numbers[end]>target){
                end--;
            }
            else if(numbers[start]+numbers[end]<target){
                start++;
            }
        }


        return ind;
    }
}
