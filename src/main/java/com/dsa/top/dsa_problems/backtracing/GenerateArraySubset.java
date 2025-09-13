package com.dsa.top.dsa_problems.backtracing;

import java.util.*;

public class GenerateArraySubset {

    public static List<List<Integer>> generateSubsets(int[] arr){

        List<List<Integer>>result=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        Arrays.sort(arr);
        Set<Integer> set=new HashSet<>();
        backtrack(arr, 0, curr,result);
        return  result;
    }

    private static void backtrack(int[] arr, int i, List<Integer> curr, List<List<Integer>> result) {
        if(i== arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        backtrack(arr, i+1,curr,result);
        curr.remove(curr.size()-1);
        backtrack(arr, i+1,curr, result);

    }

    public static void main(String[] args) {
        System.out.println(generateSubsets(new int[]{1,2,2}));
    }



}
