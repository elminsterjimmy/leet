package com.elminster;

public class Leet9 {
    public static boolean isPalindrome(int x) {
        String sInt = Integer.toString(x);
        return sInt.equals(new StringBuilder(sInt).reverse().toString());
    }
}
