package com.java_practice.DSA.Arrays;

public class isSorted {
    public static boolean isSortedHelper(int[] arr, int n){
        if(n==0 || n==1){
            return true;
        }
        return (arr[n-1]>arr[n-2])&&isSortedHelper(arr,n-1);
    }
    public static boolean isSorted(int []arr){
        return isSortedHelper(arr, arr.length);
    }

    public static void main(String[] a) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(isSorted(arr));
    }
}
