package com.dsa.top.dsa_problems.arrays;

import java.util.List;

public class CountPairs {

    public int countPairs(List<Integer> nums, int target) {
        int left=0, right=nums.size()-1;
        int count=0;
        while(left<right){
            if(nums.get(left)+nums.get(right)<=target){
                left++;
                count++;
            }else{
                right--;
            }
        }
        return count;

    }
}
