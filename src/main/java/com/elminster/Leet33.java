package com.elminster;

import java.util.Arrays;

public class Leet33 {
    public static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    static int search(int[] nums, int leftIdx, int rightIdx, int target) {
        if (leftIdx > rightIdx) {
            return -1;
        }
        int left = nums[leftIdx];
        int right = nums[rightIdx];
        int midIdx = (leftIdx + rightIdx) / 2;
        int mid = nums[midIdx];
        if (mid == target) {
            return midIdx;
        }
        if (left <= mid) {
            // left ordered
            if (target <= mid && target >= left) {
                int idx = Arrays.binarySearch(Arrays.copyOfRange(nums, leftIdx, midIdx + 1), target);
                return idx < 0 ? - 1 : leftIdx + idx;
            } else {
                return search(nums, midIdx + 1, rightIdx, target);
            }
        } else {
            // right ordered
            if (target >= mid && target <= right) {
                int idx = Arrays.binarySearch(Arrays.copyOfRange(nums, midIdx, rightIdx + 1), target);

                return idx < 0 ? -1 : midIdx + idx;
            } else {
                return search(nums, leftIdx, midIdx - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5}, 2));
    }
}
