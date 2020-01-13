package com.vivekasu;

public class MinMovesToEqualAllElement {

    public int minMoves(int[] nums) {

        int moves = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(min>nums[i])
                min = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            moves = moves + (nums[i] - min);
        }


        return moves;
    }
}
