package com.java_practice.problems;

public class binary {
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

    public static void main(String[] args) {
        System.out.println(decToBinary(50));
    }
}
