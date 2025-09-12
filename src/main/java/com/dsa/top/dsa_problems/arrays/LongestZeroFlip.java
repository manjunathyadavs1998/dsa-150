package com.dsa.top.dsa_problems.arrays;

public class LongestZeroFlip {

    public static int longestArrayKFlips(int[] arr, int k){

        //sliding window problem
        int j=0, zeros=0, maxLen=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0)zeros++;
            while(zeros>k){
                if(arr[j]==0)
                    zeros--;
            j++;
            }
            maxLen=Math.max(maxLen,i-j+1);
        }
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
}
