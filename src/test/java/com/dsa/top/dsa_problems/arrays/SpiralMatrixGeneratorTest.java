package com.dsa.top.dsa_problems.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpiralMatrixGeneratorTest {

    SpiralMatrix generator = new SpiralMatrix();

    @Test
    void testNIsZero() {
        int[][] result = generator.generateSpiralOrder(0);
        assertEquals(0, result.length, "Matrix should be empty when n=0");
    }

    @Test
    void testNIsOne() {
        int[][] expected = {{1}};
        int[][] result = generator.generateSpiralOrder(1);
        assertArrayEquals(expected, result, "Matrix for n=1 is incorrect");
    }

    @Test
    void testNIsTwo() {
        int[][] expected = {
                {1, 2},
                {4, 3}
        };
        int[][] result = generator.generateSpiralOrder(2);
        assertArrayEquals(expected, result, "Matrix for n=2 is incorrect");
    }

    @Test
    void testNIsThree() {
        int[][] expected = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] result = generator.generateSpiralOrder(3);
        assertArrayEquals(expected, result, "Matrix for n=3 is incorrect");
    }

    @Test
    void testNIsFour() {
        int[][] expected = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        int[][] result = generator.generateSpiralOrder(4);
        assertArrayEquals(expected, result, "Matrix for n=4 is incorrect");
    }
}

