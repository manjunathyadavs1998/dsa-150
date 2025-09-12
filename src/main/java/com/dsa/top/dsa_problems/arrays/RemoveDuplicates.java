package com.dsa.top.dsa_problems.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] removeDuplicatesFromSortedArray(int[] input){
        int n=input.length;
        if(n<=1) return input;
        int i=1, j=1;
        while(j<n){
            if(input[j]!=input[j-1]){
                input[i]=input[j];
                i++;
            }
            j++;
        }
        return Arrays.copyOfRange(input, 0, i);
    }
}
