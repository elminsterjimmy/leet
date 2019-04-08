package com.elminster;

public class Leet53 {


    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums.length > 0) {
            int fn = nums[0];
            for (int i = 0; i < nums.length; i++) {
                //System.out.println(String.format("fn = %d, nums[%d] = %d, max = %d", fn, i, nums[i], max));
                fn = Math.max(nums[i], fn + nums[i]);
                System.out.println(String.format("set fn = %d", fn));
                max = Math.max(fn, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
