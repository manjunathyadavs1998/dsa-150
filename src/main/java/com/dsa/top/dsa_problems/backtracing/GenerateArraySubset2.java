package com.dsa.top.dsa_problems.backtracing;



import java.util.*;

public class GenerateArraySubset2 {

    public static List<List<Integer>> subsetsWithDup(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // important for duplicate skipping
        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int index, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;

            curr.add(arr[i]);
            backtrack(arr, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
        // Expected: [[], [1], [1,2], [1,2,2], [2], [2,2]]
    }
}

