package com.elminster;

public class Leet6 {

    public static String convert(String s, int numRows) {
        // first line / last line: f(n + 1) = f(n) + 2 * numRows - 2
        // let k = 2 * (numRows - 2)
        // 1st / last line: f(n + 1) = k
        // other lines: f(n + 1) = f(n) + 2 * (numRows - rowNum) | f(n) + k - 2 * (numRows - rowNum)
        if (null == s || s.length() == 0 || numRows < 1) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] subStirngs = new StringBuilder[numRows];
        int span = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            subStirngs[i] = new StringBuilder(s.length() / numRows);
            boolean flag = true;
            for (int j = i; j < s.length();) {
                subStirngs[i].append(s.charAt(j));
                if (i == 0 || i == numRows - 1) { // first line or last line
                    j += span;
                } else {
                    if (flag) {
                        j += 2 * (numRows - i - 1);
                    } else {
                        j += span - 2 * (numRows - i - 1);
                    }
                    flag = !flag;
                }
            }
        }
        for (int i = 1; i < numRows; i++) {
            subStirngs[0].append(subStirngs[i]);
        }
        return subStirngs[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
