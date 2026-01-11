package com.java_practice.DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    //find the element at the given row and column
    public static int nCr(int n, int r){
        int ans = 1;
        for(int i=0; i<r; i++){
            ans = ans * (n-i);
            ans = ans / (i+1);
        }
        return ans;
    }

    //print the nth row of the pascal triangle O(n) time complexity
    public static void pascalNthRow(int n){
        int ans = 1;
        System.out.print(ans + " ");
        for(int i=1; i<n; i++){
            ans = ans * (n-i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
    }

    //print pascal triangle
    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> triangle = new ArrayList<>();
        if(n == 0) return triangle;
        for(int i=1; i<n; i++){
            List<Integer> rows = new ArrayList<>();
            for(int j=1; j<=i; j++){
                if(j == 0 || j == i){
                    rows.add(1);
                }else {
                    List<Integer> prevRow = triangle.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    rows.add(sum);
                }
            }
            triangle.add(rows);
        }
        return triangle;
    }

}
