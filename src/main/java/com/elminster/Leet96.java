package com.elminster;

public class Leet96 {

    public static int numTrees(int n) {
        // f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + ... + f(n - 1) * f(0)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int root = 1; root <= i; root++) {
                int left = root - 1;
                int right = i - root;
                sum += dp[left] * dp[right];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
