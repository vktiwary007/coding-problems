package com.vivekasu;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length<=0)
            return 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        PriorityQueue<Integer> nextfreepq = new PriorityQueue<Integer>((a, b)->a-b);
        int minrooms = 1;
        nextfreepq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){

            if(nextfreepq.peek()>intervals[i][0]){
                minrooms++;
                nextfreepq.add(intervals[i][1]);
            }
            else{
                nextfreepq.poll();
                nextfreepq.add(intervals[i][1]);
            }

        }

        return minrooms;

    }
}
