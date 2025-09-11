package com.dsa.top.dsa_problems.arrays;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SpiralMatrixTest {

    @Test
    void testSingleElement() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{1}};
        List<Integer> expected = List.of(1);
        assertEquals(expected, sm.spiralOrder(matrix));


    }

    @Test
    void testSingleRow() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, sm.spiralOrder(matrix));
    }

    @Test
    void testSingleColumn() {



        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, sm.spiralOrder(matrix));
    }

    @Test
    void testSquareMatrix3x3() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = Arrays.asList(1,2,3,6,9,8,7,4,5);
        assertEquals(expected, sm.spiralOrder(matrix));
    }

    @Test
    void testRectangularMatrix3x4() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };
        List<Integer> expected = Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);
        assertEquals(expected, sm.spiralOrder(matrix));
    }

    @Test
    void testRectangularMatrix4x3() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1,  2,  3},
                {4,  5,  6},
                {7,  8,  9},
                {10, 11, 12}
        };
        List<Integer> expected = Arrays.asList(1,2,3,6,9,12,11,10,7,4,5,8);
        assertEquals(expected, sm.spiralOrder(matrix));
    }

    @Test
    void testSquareMatrix4x4() {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> expected = Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
        assertEquals(expected, sm.spiralOrder(matrix));
    }
}
