package com.shenghaishxt.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0003_无重复字符的最长子串 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new _0003_无重复字符的最长子串().lengthOfLongestSubstring("pwwkew"));
    }
}
