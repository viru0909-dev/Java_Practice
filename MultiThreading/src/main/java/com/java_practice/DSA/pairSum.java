package com.java_practice.DSA;

import java.util.ArrayList;

public class pairSum {

    //brute force
    public static ArrayList<Integer> pairSum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int n  = arr.length;
        for (int i = 0; i < n; i++) {
           for(int j = i + 1; j < n; j++){
               if(arr[i] + arr[j] == target){
                   list.add(i);
                   list.add(j);
               }
           }
        }
        return list;
    }

    //better approach
    public static ArrayList<Integer> pairSum2(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int n  = arr.length;
        int i = 0, j = n - 1;

        while(i < j){
            int pairSum = arr[i] + arr[j];
            if(pairSum > target) j--;
            else if ( pairSum < target) i++;
            else{
                list.add(i);
                list.add(j);
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println("Brute Force for pairSum = "+pairSum(arr,target));
        System.out.println("Better Approach for pairSum = "+pairSum2(arr,target));
    }
}
