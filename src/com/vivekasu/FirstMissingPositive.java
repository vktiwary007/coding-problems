package com.vivekasu;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>0 && min>nums[i]){
                min = nums[i];
            }
        }

        if(min>1)
            return 1;

        for(int i=0;i<n;i++){

            if(nums[i]==0 || nums[i]<0 || nums[i]>n){
                nums[i] = 1;
            }

        }

        for(int i=0;i<n;i++){

            int elem = nums[i];
            int abselem = Math.abs(nums[i]);

            if(abselem<n && abselem>0 && nums[abselem]>0){
                nums[abselem] = -nums[abselem];
            }
            else if(abselem==n){
                int tmp = nums[0];
                if(Math.abs(tmp)!=n && nums[Math.abs(tmp)]>0){
                    nums[Math.abs(tmp)] = -nums[Math.abs(tmp)];
                }
                nums[0] = -n;
                if(nums[i]<0)
                    nums[i] = tmp>0?-tmp:tmp;
                else
                    nums[i] = tmp>0?tmp:-tmp;

            }


        }

        int firstPositive = -1;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]>0){
                firstPositive = i;
                break;
            }
            else if(i==0 && nums[i]>0){
                firstPositive = n;
            }

        }

        if(firstPositive<0)
            firstPositive = n+1;

        return firstPositive;
    }
}
