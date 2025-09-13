package com.dsa.top.dsa_problems.backtracing;

import java.util.*;

public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int k, int target, List<Integer> curr, List<List<Integer>> result) {
        // ✅ Base case
        if (curr.size() == k && target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // If invalid, stop exploring
        if (curr.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, k, target - i, curr, result); // move forward
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));  // [[1,2,4]]
        System.out.println(combinationSum3(3, 9));  // [[1,2,6],[1,3,5],[2,3,4]]
    }
}

