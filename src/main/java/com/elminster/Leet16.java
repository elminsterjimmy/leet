package com.elminster;

import java.util.Arrays;

public class Leet16 {

    public static int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return target;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] + nums[1];
        }

        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    right--;
                }
                if (sum < target) {
                    left++;
                }


                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
