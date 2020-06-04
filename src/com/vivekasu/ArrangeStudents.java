package com.vivekasu;

import java.util.Collections;
import java.util.List;

public class ArrangeStudents {

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
        // Write your code here
        Collections.sort(a);
        Collections.sort(b);

        int i=0, j=0;
        String possible = "YES";
        boolean isBoy = false;
        if(a.get(0)<=b.get(j)){
            i++;
            isBoy = true;
        }
        else{
            j++;
        }

        while(i<a.size() && j<b.size()){

            if(a.get(i)<=b.get(j) && !isBoy){
                i++;
                isBoy = true;
            }
            else if(b.get(j)<=a.get(i) && isBoy){
                j++;
                isBoy = false;
            }
            else{
                return "NO";
            }

        }

        if(Math.abs(i-j)>1)
            return "NO";

        return possible;

    }
}
