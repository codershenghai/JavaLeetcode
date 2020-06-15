package com.shenghaishxt.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class _0003_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("dvdf")); //3
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("")); //0
    }
}
