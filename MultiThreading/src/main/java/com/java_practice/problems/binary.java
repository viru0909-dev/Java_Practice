package com.java_practice.problems;

public class binary {

    //converting a decimal Number to Binary Number
    public static int decToBinary(int n){
        int sum = 0, pow = 1;
        while (n > 0){
         int rem = n % 2;
         n /= 2;
         sum += (pow * rem);
         pow *= 10;
        }
        return sum;
    }


    //converting a binary number to decimal Number
    public static int binToDec(int n){
        int sum = 0, pow = 1;
        while (n > 0){
            int rem = n % 10;
            sum += rem * pow;
            n /= 10;
            pow *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(decToBinary(50));
        System.out.println(binToDec(110010));
    }
}
