package com.java_practice.DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class freqOfArrayList {
    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr){
        int n = arr.length;

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(visited[i] == true)
                continue;
            int count =1;

            for(int j = i+1; j < n; j++){
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            temp.add(count);
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        ArrayList<ArrayList<Integer>> ans = countFreq(arr);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
