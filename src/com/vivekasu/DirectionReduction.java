package com.vivekasu;

import java.util.Arrays;
import java.util.Stack;

public class DirectionReduction {

    public static void main(String[] args){

        String[] arr = {"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"};
        System.out.println(Arrays.toString(dirReduc(arr)));
    }

    //constant direction array
    private static final String[] directions = {"NORTH","SOUTH","EAST","WEST"};
    public static String[] dirReduc(String[] arr) {

        //stack to keep track of needed directions
        Stack<String> dirStack = new Stack<>();

        for(int i=0;i<arr.length;i++){

            //push the direction stack if its empty
            if(dirStack.isEmpty()){
                dirStack.push(arr[i]);
            }
            else{
                //check if directions needed to be removed or not, accordingly then push or pop the value
                if(checkToRemoveDirection(arr[i], dirStack.peek())){
                    dirStack.pop();
                }
                else{
                    dirStack.push(arr[i]);
                }

            }

        }

        //output array for reduced direction
        String[] reducedDir = new String[dirStack.size()];
        int i = dirStack.size()-1;
        while(!dirStack.isEmpty()){
            reducedDir[i--] = dirStack.pop();
        }

        return reducedDir;
    }

    /**
     *This method compares current direction and previous direction encountered and
     *checks if these two directions are needed to be removed or not.
     *
     *@param currDir the current direction in the array
     *@param prevDir the previous direction in the array
     *@return boolean value if these two directions are needed in final output
     */
    public static boolean checkToRemoveDirection(String currDir, String prevDir){

        if(currDir.equals(directions[0])){
            return prevDir.equals(directions[1]);
        }
        else if(currDir.equals(directions[1])){
            return prevDir.equals(directions[0]);
        }
        else if(currDir.equals(directions[2])){
            return prevDir.equals(directions[3]);
        }
        else {
            return prevDir.equals(directions[2]);
        }


    }
}
