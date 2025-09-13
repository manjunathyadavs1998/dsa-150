package com.dsa.top.dsa_problems.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

    @Test
    void testExampleCase1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        assertEquals(2, SubarraySumEqualsK.subarraySum(nums, k));
    }

    @Test
    void testExampleCase2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        assertEquals(2, SubarraySumEqualsK.subarraySum(nums, k)); // [1,2], [3]
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-1, -1, 1};
        int k = 0;
        assertEquals(1, SubarraySumEqualsK.subarraySum(nums, k)); // [-1, -1, 1]
    }

    @Test
    void testSingleElementEqualsK() {
        int[] nums = {3};
        int k = 3;
        assertEquals(1, SubarraySumEqualsK.subarraySum(nums, k));
    }

    @Test
    void testSingleElementNotEqualsK() {
        int[] nums = {3};
        int k = 5;
        assertEquals(0, SubarraySumEqualsK.subarraySum(nums, k));
    }

    @Test
    void testLargeArrayWithMultipleSubarrays() {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
        assertEquals(4, SubarraySumEqualsK.subarraySum(nums, k)); // [1,2], [2,1], [1,2], [2,1]
    }

    @Test
    void testZeroTarget() {
        int[] nums = {0, 0, 0};
        int k = 0;
        assertEquals(6, SubarraySumEqualsK.subarraySum(nums, k)); // many combinations
    }
}
