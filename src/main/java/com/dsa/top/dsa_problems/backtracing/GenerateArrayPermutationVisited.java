package com.dsa.top.dsa_problems.backtracing;

import java.util.ArrayList;
import java.util.List;

public class GenerateArrayPermutationVisited {
    public static List<List<Integer>> generatePermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited=new boolean[arr.length];
        List<Integer>curr=new ArrayList<>();
        backtrack(arr, curr, visited, result);
        return result;
    }

    private static void backtrack(int[] arr, List<Integer> curr, boolean[] visited, List<List<Integer>> result) {

        if(curr.size()==arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(visited[i])continue;
            visited[i]=true;
            curr.add(arr[i]);
            backtrack(arr, curr, visited, result);
            curr.remove(curr.size()-1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        System.out.println(generatePermutations(new int[]{1,2,3}));
    }


}
