package com.vivekasu;

public class IdealNums {

    public static void main(String[] args) {
        IdealNums obj = new IdealNums();
        System.out.println(obj.getNums(40000,50000));
    }

    public long getNums(long low, long high) {
       long[] nums = new long[(int)high];
       int count = 0;
        nums[0] = 1l;
       if(nums[0]>=low)
           count++;

       long nextnum;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < (int)high; ++i) {
            nextnum = Math.min(nums[i3] * 3, nums[i5] * 5);
            nums[i] = nextnum;
            if(nums[i]>=low && nums[i]<=high)
                count++;
            if (nextnum == nums[i3] * 3) ++i3;
            if (nextnum == nums[i5] * 5) ++i5;
        }

        return count;
    }

}
