package com.elminster;

import java.util.HashMap;
import java.util.Map;

public class Leet3 {

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> idxMap = new HashMap<>();
    int longest = 0;
    int substringLen = 0;
    int lastOcc = -1;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      Integer idx = idxMap.get(ch);
      if (null != idx && idx > lastOcc) {
        longest = Math.max(longest, substringLen);
        lastOcc = idx;
        substringLen = i - idx;
      } else {
        substringLen++;
      }
      idxMap.put(ch, i);
    }
    longest = Math.max(longest, substringLen);
    return longest;
  }

  public static void main(String[] args) {
//    System.out.println(lengthOfLongestSubstring("abcabcbb"));
//    System.out.println(lengthOfLongestSubstring("bbbbb"));
//    System.out.println(lengthOfLongestSubstring("pwwkew"));
//    System.out.println(lengthOfLongestSubstring(""));
//    System.out.println(lengthOfLongestSubstring("aab"));
//    System.out.println(lengthOfLongestSubstring("abba"));
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
}
