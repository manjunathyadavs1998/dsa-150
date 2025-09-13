package com.dsa.top.dsa_problems.backtracing;

import java.util.ArrayList;
import java.util.List;

public class GenerateStringSubset {

    public static List<String> generateSubsets(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) return result; // safeguard
        backtrack(str.toCharArray(), 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(char[] arr, int i, StringBuilder curr, List<String> result) {
        if (i == arr.length) {
            result.add(curr.toString());
            return;
        }

        // Choice 1: Include character
        curr.append(arr[i]);
        backtrack(arr, i + 1, curr, result);
        curr.deleteCharAt(curr.length() - 1);

        // Choice 2: Exclude character
        backtrack(arr, i + 1, curr, result);
    }

    public static void main(String[] args) {
        System.out.println(generateSubsets("abc")); // prints all 8 subsets
        System.out.println(generateSubsets("abc").size()); // should print 8
    }
}
