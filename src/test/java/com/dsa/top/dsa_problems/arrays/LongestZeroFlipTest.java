package com.dsa.top.dsa_problems.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestZeroFlipTest {

    @Test
    void testAllOnes() {
        int[] arr = {1, 1, 1, 1};
        assertEquals(4, LongestZeroFlip.longestArrayKFlips(arr, 2));
    }

    @Test
    void testAllZeros() {
        int[] arr = {0, 0, 0};
        assertEquals(2, LongestZeroFlip.longestArrayKFlips(arr, 2));
    }

    @Test
    void testMixedArray() {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        assertEquals(6, LongestZeroFlip.longestArrayKFlips(arr, 2));
    }

    @Test
    void testSingleElementOne() {
        int[] arr = {1};
        assertEquals(1, LongestZeroFlip.longestArrayKFlips(arr, 1));
    }

    @Test
    void testSingleElementZero() {
        int[] arr = {0};
        assertEquals(1, LongestZeroFlip.longestArrayKFlips(arr, 1));
        assertEquals(0, LongestZeroFlip.longestArrayKFlips(arr, 0));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, LongestZeroFlip.longestArrayKFlips(arr, 1));
    }
}

