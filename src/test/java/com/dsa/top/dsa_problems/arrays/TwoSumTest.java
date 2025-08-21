package com.dsa.top.dsa_problems.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    void testNullArray() {
        int[] result = TwoSum.twoSum(null, 10);
        assertArrayEquals(new int[]{-1, -1}, result, "Null array should return {-1, -1}");
    }

    @Test
    void testSingleElementArray() {
        int[] result = TwoSum.twoSum(new int[]{5}, 10);
        assertArrayEquals(new int[]{-1, -1}, result, "Single element array should return {-1, -1}");
    }

    @Test
    void testNoPairExists() {
        int[] arr = {1, 2, 3, 4};
        int[] result = TwoSum.twoSum(arr, 100);
        assertArrayEquals(new int[]{-1, -1}, result, "No pair should return {-1, -1}");
    }

    @Test
    void testPairExists() {
        int[] arr = {2, 7, 11, 15};
        int[] result = TwoSum.twoSum(arr, 9);
        assertArrayEquals(new int[]{0, 1}, result, "2 + 7 = 9 should return indices {0, 1}");
    }

    @Test
    void testPairExistsUnordered() {
        int[] arr = {3, 2, 4};
        int[] result = TwoSum.twoSum(arr, 6);
        assertArrayEquals(new int[]{1, 2}, result, "2 + 4 = 6 should return indices {1, 2}");
    }

    @Test
    void testMultiplePairs() {
        int[] arr = {1, 3, 2, 4};
        int[] result = TwoSum.twoSum(arr, 5);
        // First valid pair found: 3 (index 1) + 2 (index 2)
        assertArrayEquals(new int[]{1, 2}, result, "3 + 2 = 5 should return indices {1, 2}");
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-3, 4, 3, 90};
        int[] result = TwoSum.twoSum(arr, 0);
        assertArrayEquals(new int[]{0, 2}, result, "-3 + 3 = 0 should return indices {0, 2}");
    }
}

