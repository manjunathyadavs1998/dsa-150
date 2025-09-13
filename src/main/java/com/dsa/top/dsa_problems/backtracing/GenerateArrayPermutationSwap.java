package com.dsa.top.dsa_problems.backtracing;


import java.util.*;

public class GenerateArrayPermutationSwap {

    public static List<List<Integer>> generatePermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private static void backtrack(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            // Convert array to list and add
            List<Integer> perm = new ArrayList<>();
            for (int num : arr) perm.add(num);
            result.add(perm);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);  // fix element at index
            backtrack(arr, index + 1, result);
            swap(arr, index, i);  // backtrack (undo swap)
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(generatePermutations(new int[]{1, 2, 3}));
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2]]
    }
}

