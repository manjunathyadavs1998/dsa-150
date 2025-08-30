package com.dsa.top.dsa_problems.arrays;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {


    @Test
    void testExampleCase() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, ContainerWithMostWater.maxArea(height), "Example test case failed");
    }

    @Test
    void testTwoElements() {
        int[] height = {1, 1};
        assertEquals(1, ContainerWithMostWater.maxArea(height), "Two equal heights case failed");

        int[] height2 = {1, 5};
        assertEquals(1, ContainerWithMostWater.maxArea(height2), "Two elements with different heights failed");
    }

    @Test
    void testAllSameHeights() {
        int[] height = {4,4,4,4};
        assertEquals(12, ContainerWithMostWater.maxArea(height), "All same heights case failed");
    }

    @Test
    void testIncreasingHeights() {
        int[] height = {1,2,3,4,5};
        assertEquals(6, ContainerWithMostWater.maxArea(height), "Increasing heights case failed");
    }

    @Test
    void testDecreasingHeights() {
        int[] height = {5,4,3,2,1};
        assertEquals(6, ContainerWithMostWater.maxArea(height), "Decreasing heights case failed");
    }

    @Test
    void testSingleElement() {
        int[] height = {5};
        assertEquals(0, ContainerWithMostWater.maxArea(height), "Single element case should return 0");
    }

    @Test
    void testLargeInput() {
        int n = 10000;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = i % 100;  // repeating heights
        }
        int result = ContainerWithMostWater.maxArea(height);
        assertTrue(result > 0, "Large input should return positive area");
    }
}
