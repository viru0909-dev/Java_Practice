package com.java_practice.DSA;

/*
*Book Allocation Problem
 There are N books, each book has ith book has A[i] number of pages.
 You have to allocate books to M number of students so that the max no. of pages allocated to
 a student is minimum.

 * each book should allocate to a student
 * each student has to be allocated at least one book
 * allotment should be un contiguous order

 */

public class bookAllocation {


    //binary method
    public static int allocateBooks(int[] arr, int n, int m){
        if(m>n)return -1;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
        }
        int ans = -1;
        int st=0, end=sum;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(isValid(arr,n,m,mid)){//left
                ans = mid;
                end = mid-1;
            }else{//right
                st = mid+1;
            }
        }
        return ans;
    }

    //helper method
    private static boolean isValid(int[] arr,int n,int m,int maxAllowedPages){
        int students=1, pages=0;
        for(int i=0;i<n;i++){
            if(arr[i]>maxAllowedPages){
                return false;
            }
            if(pages+arr[i] <= maxAllowedPages){
                pages+=arr[i];
            }else{
                students++;
                pages=arr[i];
            }
        }
        return students > m ? false:true;
    }

    public static void main(String[] args) {
        int arr[]= {2,1,3,4};
        int n = 4, m =2;
        System.out.println(allocateBooks(arr, n, m));
    }



}
