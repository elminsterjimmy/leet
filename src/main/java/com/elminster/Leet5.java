package com.elminster;

public class Leet5 {

    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }


        String longestString = "";
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int left = i - 1;
            int right = i + 1;
            int slen = 1;
            String str = "" + c;
            if (slen > maxLen) {
                maxLen = slen;
                longestString = str;
            }
            boolean repeat = true;
            for (; ; ) {
                if (left < 0 && right >= len) {
                    break;
                }
                String leftChar = left >= 0 ? "" + s.charAt(left) : "";
                String rightChar = right < len ? "" + s.charAt(right) : "";

                if (leftChar.equals(rightChar)) {
                    left--;
                    right++;
                    slen += 2;
                    str = leftChar + str + rightChar;
                    if (repeat && leftChar.charAt(0) != c) {
                        repeat = false;
                    }
                    if (slen > maxLen) {
                        maxLen = slen;
                        longestString = str;
                    }
                } else {
                    if (repeat && leftChar.length() > 0 && leftChar.charAt(0) == c) {
                        left--;
                        slen += 1;
                        str = leftChar + str;
                        if (slen > maxLen) {
                            maxLen = slen;
                            longestString = str;
                        }
                    }
                    if (repeat && rightChar.length() > 0 && rightChar.charAt(0) == c) {
                        right++;
                        slen += 1;
                        str = str + rightChar;
                        if (slen > maxLen) {
                            maxLen = slen;
                            longestString = str;
                        }
                    } else {
                        break;
                    }
                }

            }
        }

        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
