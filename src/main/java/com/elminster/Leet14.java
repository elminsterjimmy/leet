package com.elminster;

public class Leet14 {
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder(strs[0].length());
        outter:
        for (int i = 0; i < strs[0].length(); i++) {
            char c = '0';
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    break outter;
                }
                if ('0' == c) {
                    c = strs[j].charAt(i);
                } else {
                    if (c != strs[j].charAt(i)) {
                        break outter;
                    }
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
