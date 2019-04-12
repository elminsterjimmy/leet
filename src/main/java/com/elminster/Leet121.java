package com.elminster;

public class Leet121 {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            max = dp[i] > max ? dp[i] : max;
            min = prices[i] < min ? prices[i] : min;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
