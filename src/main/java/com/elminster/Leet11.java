package com.elminster;

public class Leet11 {

    public static int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int size = (right - left) * Math.min(height[left], height[right]);
            if (size > max) {
                max = size;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
