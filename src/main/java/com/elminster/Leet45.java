package com.elminster;

public class Leet45 {
    public static int jump(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int jumps = 0, end = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                jumps++;
                end = max;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4}));
    }
}
