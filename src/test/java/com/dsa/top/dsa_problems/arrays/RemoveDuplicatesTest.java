package com.dsa.top.dsa_problems.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testSingleElementArray() {
        int[] input = {5};
        int[] expected = {5};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testNoDuplicates() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testAllDuplicates() {
        int[] input = {2, 2, 2, 2};
        int[] expected = {2};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testMixedDuplicates() {
        int[] input = {1, 1, 2, 2, 3, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testDuplicatesAtEnd() {
        int[] input = {1, 2, 3, 4, 4, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }

    @Test
    void testLargeArray() {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4};
        assertArrayEquals(expected, RemoveDuplicates.removeDuplicatesFromSortedArray(input));
    }
}
