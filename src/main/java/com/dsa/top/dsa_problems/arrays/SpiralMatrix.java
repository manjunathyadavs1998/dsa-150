package com.dsa.top.dsa_problems.arrays;

import java.util.*;
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // traverse top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // traverse right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }


    public int[][] generateSpiralOrder(int n) {
        if(n==0) return new int[0][0];
        int[][] matrix=new int[n][n];
        int number=1;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // traverse top row
            for (int i = left; i <= right; i++) {
                matrix[top][i]=number;
                number++;
            }
            top++;

            // traverse right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right]=number;
                number++;
            }
            right--;

            // traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i]=number;
                    number++;
                }
                bottom--;
            }

            // traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left]=number;
                    number++;
                }
                left++;
            }
        }
        return matrix;
    }
}
