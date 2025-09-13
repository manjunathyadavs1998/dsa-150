package com.dsa.top.dsa_problems.arrays;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixSum=0;
        int ans=0;
        for (int num : nums) {
            prefixSum += num;
            int currDiff = prefixSum - k;
            if (map.containsKey(currDiff)) {
                ans += map.get(currDiff);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }
}
