package com.dsa.top.dsa_problems.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] input, int target){
        Arrays.sort(input);
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backtrack(input, current, 0,result, target);
        return result;

    }

    private static void backtrack(int[] arr, List<Integer>current, int index, List<List<Integer>>result, int target){

        if(target<0)return;
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index; i<arr.length; i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            current.add(arr[i]);
            backtrack(arr,current, i+1, result, target-arr[i]);
            current.remove(current.size()-1);
        }

    }

    public static void main(String[] args) {

        //[10,1,2,7,6,1,5], target = 8
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
