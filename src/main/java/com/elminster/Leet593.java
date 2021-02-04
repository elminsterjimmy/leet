package com.elminster;

import java.util.Arrays;

public class Leet593 {

  public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    double d12 = distance(p1, p2);
    double d23 = distance(p2, p3);
    double d34 = distance(p3, p4);
    double d14 = distance(p1, p4);
    double d13 = distance(p1, p3);
    double d24 = distance(p2, p4);
    double[] distances = {d12, d13, d14, d23, d24, d34};
    Arrays.sort(distances);
    return distances[0] != 0 && distances[0] == distances[3] && distances[4] == distances[5] && 2 * distances[0] == distances[4];
  }

  public static double distance(int[] p1, int[] p2) {
    return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
  }

  public static void main(String[] args) {
    System.out.println(validSquare(new int[]{1,0},
        new int[]{0,1},
    new int[]{-1,0},
    new int[]{0,-1}));
  }
}
