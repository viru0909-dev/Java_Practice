package com.java_practice.DSA;

import java.util.ArrayList;

public class Kandane {


    public static int maxArray(int []arr){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int val : arr) {
            currSum += val;
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {3,-4,5,4,-1,7,-8};
        System.out.println(maxArray(arr));
    }

}
