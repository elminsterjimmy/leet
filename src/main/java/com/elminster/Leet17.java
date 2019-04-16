package com.elminster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet17 {

    private static Map<Character, char[]> CONVERT_MAP = new HashMap<>();
    static {
        CONVERT_MAP.put('2', new char[]{'a', 'b', 'c'});
        CONVERT_MAP.put('3', new char[]{'d', 'e', 'f'});
        CONVERT_MAP.put('4', new char[]{'g', 'h', 'i'});
        CONVERT_MAP.put('5', new char[]{'j', 'k', 'l'});
        CONVERT_MAP.put('6', new char[]{'m', 'n', 'o'});
        CONVERT_MAP.put('7', new char[]{'p', 'q', 'r', 's'});
        CONVERT_MAP.put('8', new char[]{'t', 'u', 'v'});
        CONVERT_MAP.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        List<String> rtn = new ArrayList<String>();
        if (null != digits) {
            rtn = letterCombinations(digits, 0);
        }
        return rtn;
    }

    private static List<String> letterCombinations(final String digits, final int index) {
        if (index >= digits.length()) {
            return new ArrayList<String>();
        }
        final char ch = digits.charAt(index);
        return new ArrayList<String>(4) {{
            char[] map = CONVERT_MAP.get(ch);
            if (null != map) {
                for (int i = 0; i < map.length; i++) {
                    List<String> list = letterCombinations(digits, index + 1);
                    if (list.isEmpty()) {
                        add("" + map[i]);
                    } else {
                        for (int j = 0; j < list.size(); j++) {
                            add("" + map[i] + list.get(j));
                        }
                    }
                }
            }
        }};
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
