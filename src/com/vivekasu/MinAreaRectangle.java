package com.vivekasu;

import java.util.HashSet;
import java.util.Set;

public class MinAreaRectangle {

    public int minAreaRect(int[][] points) {
        if(points.length<4)
            return 0;

        Set<String> pointset = new HashSet<>();
        int minarea = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){

            pointset.add(points[i][0]+","+points[i][1]);

        }

        for(int i=0;i<points.length;i++){

            for(int j=i+1;j<points.length;j++){

                if(points[i][0]!=points[j][0] && points[i][1]!=points[j][1]){
                    int area = Integer.MAX_VALUE;
                    String one = points[j][0]+","+points[i][1];
                    String two = points[i][0]+","+points[j][1];
                    if(pointset.contains(one) && pointset.contains(two)){
                        area = Math.abs(points[j][0]-points[i][0])*Math.abs(points[i][1]-points[j][1]);
                    }
                    minarea = Math.min(minarea, area);
                }
            }
        }

        return minarea==Integer.MAX_VALUE?0:minarea;
    }
}
