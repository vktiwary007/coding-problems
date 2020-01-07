package com.vivekasu;

import java.util.Arrays;

public class Versions {


    public static void main(String[] args){

        Versions obj = new Versions();
        System.out.println(obj.compareVersion("1.0","1.0.0"));

    }

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2 = v2.length;

        int i = 0;
        int j = 0;
        int op = 0;

        while(i<l1 || j<l2){

            int num2 = j<l2?Integer.parseInt(v2[j]):0;
            int num1 = i<l1?Integer.parseInt(v1[i]):0;

            if(num1>num2){
                op = 1;
                break;
            }
            else if(num1<num2){
                op = -1;
                break;
            }

            i++;
            j++;


        }

        return op;

    }
}
