package com.java_practice.DSA.Arrays;

public class sumOfGivenArr {
    public static int sumOfGivenArr(int[] Arr){
        int sum = 0;
        for(int i : Arr){
            sum += i;
        }
        return sum;
    }

    //recursive way
    public static int sumOfGivenArr(int[] Arr, int n){
        if(n==0){
            return 0;
        }
        return Arr[n-1] + sumOfGivenArr(Arr, n-1);
    }

    public static void main(String[] args) {
        int[] Arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sumOfGivenArr(Arr));
    }
}
