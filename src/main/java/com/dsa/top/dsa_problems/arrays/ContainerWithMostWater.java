package com.dsa.top.dsa_problems.arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int currArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currArea);

            // Move the smaller pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
