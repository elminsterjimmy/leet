package com.elminster;

public class Leet72 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        // if word1[i] == word2[j]
        //      dp[i][j] = dp[i - 1][j - 1]
        // else
        //      dp[i][j] = min(dp[i-i][j], dp[i][j-1], dp[i-1][j-1]) + 1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
