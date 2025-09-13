package com.dsa.top.dsa_problems.arrays;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArrayTest {

    @Test
    void testAllPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(15, MaximumSubArray.maxSubArray(nums));
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-8, -3, -6, -2, -5, -4};
        assertEquals(-2, MaximumSubArray.maxSubArray(nums)); // largest single element
    }

    @Test
    void testMixedNumbers() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, MaximumSubArray.maxSubArray(nums)); // subarray [4, -1, 2, 1]
    }

    @Test
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(5, MaximumSubArray.maxSubArray(nums));
    }

    @Test
    void testTwoElements() {
        int[] nums = {-2, 1};
        assertEquals(1, MaximumSubArray.maxSubArray(nums));
    }

    @Test
    void testLargeArray() {
        int[] nums = {100, -90, 200, -50, 300, -10, 400};
        assertEquals(850, MaximumSubArray.maxSubArray(nums));
    }
}
