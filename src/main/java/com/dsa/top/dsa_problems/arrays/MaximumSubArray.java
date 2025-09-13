package com.dsa.top.dsa_problems.arrays;

public class MaximumSubArray {

    public static int maxSubArray(int[] arr){
        int maxSum=arr[0];
        int currSum=0;
        for (int j : arr) {
            currSum += j;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}
