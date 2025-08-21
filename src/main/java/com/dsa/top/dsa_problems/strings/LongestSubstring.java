package com.dsa.top.dsa_problems.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String input){
        if(input==null || input.isEmpty())
            return 0;
        int n=input.length();
        if(n==1) return 1;
        Map<Character, Integer> map=new HashMap<>();
        int maxLength=Integer.MIN_VALUE,  start=0;
        for(int i=0; i<n; i++){
            char curr=input.charAt(i);
            if(map.containsKey(curr)&&map.get(curr)>=start){
                start=map.get(curr)+1;
            }
            map.put(curr, i);
            maxLength=Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }
}
