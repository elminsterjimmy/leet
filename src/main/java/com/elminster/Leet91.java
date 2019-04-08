package com.elminster;

public class Leet91 {

    public static int numDecodings(String s) {
        if (null == s || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) < 27) {
                dp[i] = i == 1 ? 1 : dp[i - 2];
            }
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }
}
