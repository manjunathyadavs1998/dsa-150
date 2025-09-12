package com.dsa.top.dsa_problems.arrays;

public class ProductArray {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        if(n==1) return new int[]{nums[0]};
        int[] out=new int[n];
        int left=1;
        out[0]=nums[0];
        for(int i=1; i<n; i++){
            left=left*out[i-1];
            out[i]=left;
        }
        int right=nums[n-1];
        for(int i=n-2; i>=0; i--){
            right=right*nums[i+1];
            out[i]=right;
        }
        return  out;
    }
}
