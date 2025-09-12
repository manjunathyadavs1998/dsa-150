package com.dsa.top.dsa_problems.arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h=Math.min(height[left], height[right]);
            int currArea =  h* width;
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            while(left<right&&height[left]<=h)left++;
            while(left<right&&height[right]<=h)right--;
        }

        return maxArea;
    }
}
