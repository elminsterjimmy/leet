package com.elminster;

public class Leet264 {

  static class Solution {


    public int nthUglyNumber(int n) {
      int nums[] = new int[n];
      nums[0] = 1;
      int ugly, i2 = 0, i3 = 0, i5 = 0;

      for (int i = 1; i < n; ++i) {
        ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
        nums[i] = ugly;

        // when dup
        if (ugly == nums[i2] * 2) i2++;
        if (ugly == nums[i3] * 3) i3++;
        if (ugly == nums[i5] * 5) i5++;
      }

      return nums[n - 1];
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.nthUglyNumber(10));
  }
}
