package com.java_practice.problems;

public class BinarySearch {

    //iterative method
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    //recursion method
    public static int binarySearch2(int[] arr, int target, int start, int end){
        if(start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                return binarySearch2(arr, target, mid+1, end);
            }else if (target < arr[mid]){
                return binarySearch2(arr, target, start, mid-1);
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int target = 1;
        int start = 0, end = arr.length - 1;

        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearch2(arr, 5, start, end));
    }
}
