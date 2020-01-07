package com.vivekasu;

public class FIndDuplicate {

    public int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];


        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }while(tortoise!=hare);

        int n1 = nums[0];
        int n2 = tortoise;
        while(n1!=n2){

            n1 = nums[n1];
            n2 = nums[n2];

        }

        return n1;
    }
}
