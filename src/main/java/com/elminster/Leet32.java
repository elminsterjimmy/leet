package com.elminster;

public class Leet32 {

    public static int longestValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLen = 0;
        int[] flag = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - flag[i - 1] - 1 >= 0 && s.charAt(i - flag[i - 1] - 1) == '(') {
                    flag[i] = flag[i - 1] + 2;
                }
                if (i - flag[i] >= 0) {
                    flag[i] += flag[i - flag[i]];
                }
                maxLen = flag[i] > maxLen ? flag[i] : maxLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))())("));
    }
}
