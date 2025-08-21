package com.dsa.top.dsa_problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //2,3,4  6
    public static int[] twoSum(int [] arr, int k){
        if(arr==null) return new int[] {-1, -1};
        int n=arr.length;
        if(n==1) return new int[] {-1, -1};
        Map<Integer, Integer> map=new HashMap<>();
        map.put(arr[0],0);
        for(int i=1; i<n; i++){
            int curr=k-arr[i];
            if(map.containsKey(curr))
                return new int[]{map.get(curr), i};
            else
                map.put(arr[i], i);
        }
        return new int[]{-1, -1};

    }
}
