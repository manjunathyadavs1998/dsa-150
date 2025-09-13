package com.dsa.top.dsa_problems.backtrack;

import com.dsa.top.dsa_problems.backtracing.GenerateArraySubset;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GenerateArraySubsetTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        List<List<Integer>> result = GenerateArraySubset.generateSubsets(arr);

        // Only one subset: []
        assertEquals(1, result.size());
        assertTrue(result.contains(Collections.emptyList()));
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {1};
        List<List<Integer>> result = GenerateArraySubset.generateSubsets(arr);

        // Subsets: [], [1]
        assertEquals(2, result.size());
        assertTrue(result.contains(Collections.emptyList()));
        assertTrue(result.contains(List.of(1)));
    }

    @Test
    void testTwoElementArray() {
        int[] arr = {1, 2};
        List<List<Integer>> result = GenerateArraySubset.generateSubsets(arr);

        // Subsets: [], [1], [2], [1,2]
        List<List<Integer>> expected = Arrays.asList(
                Collections.emptyList(),
                List.of(1),
                List.of(2),
                Arrays.asList(1, 2)
        );

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testThreeElementArray() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = GenerateArraySubset.generateSubsets(arr);

        // Total subsets = 2^3 = 8
        assertEquals(8, result.size());

        List<List<Integer>> expected = Arrays.asList(
                Collections.emptyList(),
                List.of(1),
                List.of(2),
                List.of(3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );

        assertTrue(result.containsAll(expected));
    }

    @Test
    void testDuplicateElements() {
        int[] arr = {1, 1};
        List<List<Integer>> result = GenerateArraySubset.generateSubsets(arr);

        // Expected: [], [1], [1], [1,1]
        // Note: Duplicates are not removed in current implementation
        assertEquals(4, result.size());
        assertTrue(result.contains(Arrays.asList(1, 1)));
    }
}

