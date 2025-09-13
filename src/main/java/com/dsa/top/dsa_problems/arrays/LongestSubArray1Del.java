package com.dsa.top.dsa_problems.arrays;

public class LongestSubArray1Del {

    public int longestSubarray(int[] nums) {

        int n=nums.length;
        int zeros=0;
        for(int i:nums){
            if(i==0) zeros++;
        }
        if(zeros==0) return Math.max(n - 2, 0);

        int left=0, maxLen=0;
        zeros=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0) zeros++;
            while(zeros>1){
                if(nums[left]==0) zeros--;
                left++;
            }
            maxLen=Math.max(maxLen, i-left+1);

        }

        return maxLen-1;

    }
}
