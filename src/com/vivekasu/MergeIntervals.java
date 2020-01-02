package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {


        if(intervals.length<=1){
            return intervals;
        }

        int row = intervals.length;
        List<int[]> mergeList = new ArrayList<int[]>();

        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        int[] curr = new int[2];
        curr[0] = intervals[0][0];
        curr[1] = intervals[0][1];
        mergeList.add(curr);
        int lastind = 0;
        for(int i=1;i<row;i++){
            if(mergeList.get(lastind)[1] >= intervals[i][0]){
                if(mergeList.get(lastind)[1]<intervals[i][1])
                    mergeList.get(lastind)[1] = intervals[i][1];

            }
            else{
                curr = intervals[i];
                mergeList.add(curr);
                lastind++;
            }

        }

        return mergeList.toArray(new int[mergeList.size()][2]) ;
    }
}
