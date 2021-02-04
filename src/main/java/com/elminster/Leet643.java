package com.elminster;

public class Leet643 {
  public static double findMaxAverage(int[] nums, int k) {
    int len = nums.length;
    if (k > len) {
      return 0.0d;
    }

    double sum = 0.0d;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    double[] sums = new double[len];
    sums[k - 1] = sum;
    for (int i = k; i < len; i++) {
      sums[i] = sums[i - 1] - nums[i - k] + nums[i];
      if (sums[i] > sum) {
        sum = sums[i];
      }
    }
    return sum / k;
  }

  public static void main(String[] args) {
    System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
    System.out.println(findMaxAverage(new int[] {4,2,1,3,3}, 2));
    System.out.println(findMaxAverage(new int[]{7,4,5,8,8,3,9,8,7,6}, 7));
  }
}
