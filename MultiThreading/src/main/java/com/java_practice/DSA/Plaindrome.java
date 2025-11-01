package com.java_practice.DSA;

public class Plaindrome {
    public static void main(String[] args) {
        int n = 121;
        int rev = 0;
        int temp = n;

        while (temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        if  (rev == n)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
